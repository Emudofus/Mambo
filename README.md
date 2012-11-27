Mambo
-----

Mambo est un émulateur Dofus 2.x écrit en Java. Il utilise Maven pour les dépendances externes et le build des projets. J'essaierais de faire le plus possible de test unitaire pour donner un exemple d'utilisation de mon code mais aussi pour s'assurer de n'avoir aucun bug.

Mambo utilise l'annotation @NotNull et la fonction Preconditions.checkNotNull(T) pour régler les problèmes de NullPointerException (et aussi s'intégrer avec Kotlin). Je déconseille l'utilisation de @Nullable, toutes les variables sont par défaut @Nullable sauf s'il y a @NotNull.