package org.mambo.core.collection

import collection.mutable
import annotation.tailrec

/**
 * @author Blackrush
 * @todo extends Iterable[(Seq[K], V)]
 */
trait NavigableTree[K, V] {
  val value: Option[V]

  def isRoot: Boolean
  def path: Seq[K]

  def get(key: K): Option[V]
  def put(key: K, value: Option[V]): NavigableTree[K, V]
  def remove(key: K): Option[NavigableTree[K, V]]

  def get(keys: Seq[K]): Option[V]
  def put(keys: Seq[K], value: Option[V]): NavigableTree[K, V]
  def remove(keys: Seq[K]): Option[NavigableTree[K, V]]

  def apply(key: K) = get(key)
  def apply(keys: Seq[K]) = get(keys)
  def update(key: K, value: Option[V]) = put(key, value)
  def update(keys: Seq[K], value: Option[V]) = put(keys, value)
}

object NavigableTree {
  def empty[K, V] = new NavigableTreeRoot[K, V]
}

class NavigableTreeRoot[K, V] extends NavigableTree[K, V] {
  private type Child = NavigableTreeChild[K, V]

  protected val children = mutable.Map.empty[K, Child]

  val value: Option[V] = None

  def isRoot = true
  def path = Seq.empty[K]

  def get(key: K) = children.get(key) match {
    case Some(child) => child.value
    case None => None
  }

  def put(key: K, value: Option[V]) = {
    val child = new Child(key, value, this)
    children(key) = child
    child
  }

  def remove(key: K) = children.remove(key)

  def get(keys: Seq[K]) = {
    val it = keys.iterator

    @tailrec
    def rec(current: NavigableTreeRoot[K, V]): Option[V] =
      if (!it.hasNext)
        current.value
      else
        current.children.get(it.next()) match {
          case Some(child) => rec(child)
          case None => current.value
        }

    rec(this)
  }

  def put(keys: Seq[K], value: Option[V]): NavigableTree[K, V] = {
    val it = keys.iterator

    if (!it.hasNext)
      throw new IllegalArgumentException("keys must have at least one element")

    @tailrec
    def rec(current: NavigableTreeRoot[K, V]): NavigableTree[K, V] = {
      val key = it.next()
      if (!it.hasNext)
        current.put(key, value)
      else
        rec(current.children.get(key).getOrElse(current.put(key, None)))
    }

    rec(this)
  }

  def remove(keys: Seq[K]): Option[NavigableTree[K, V]] = {
    val it = keys.iterator

    if (!it.hasNext)
      throw new IllegalArgumentException("keys must have at least one element")

    @tailrec
    def rec(current: NavigableTreeRoot[K, V]): Option[NavigableTree[K, V]] = {
      val key = it.next()
      if (!it.hasNext)
        current.remove(key)
      else
        current.children.get(key) match {
          case Some(child) => rec(child)
          case None => None
        }
    }

    rec(this)
  }
}

class NavigableTreeChild[K, V](val key: K, override val value: Option[V] = None, val parent: NavigableTree[K, V]) extends NavigableTreeRoot[K, V] {
  private type This = NavigableTreeChild[K, V]

  override def isRoot = false
  override def path = parent.path :+ key
}
