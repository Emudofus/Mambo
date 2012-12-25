package org.mambo.core.login.database.model;

import org.jetbrains.annotations.NotNull;
import org.joda.time.Instant;
import org.mambo.shared.database.annotations.Column;
import org.mambo.shared.database.annotations.Id;
import org.mambo.shared.database.annotations.Table;
import org.mambo.shared.database.impl.Model;
import org.mambo.shared.database.impl.converter.SqlTimestampToJodaInstant;

/**
 * @author Blackrush
 */
@Table("users")
public class User extends Model<User> {
    public static enum Right {
        GOD,
        SUPER_ADMIN,
        ADMIN,
        GAME_MASTER,
        MODERATOR,
        USER,
        BANNED
    }

    @Id
    @Column
    private Long id = 0L;

    @Column
    private String username = "";

    @Column(name="password_hash")
    private String passwordHash = "";

    @Column
    private String salt = "";

    @Column
    private String nickname = "";

    @Column
    private String email = "";

    @Column
    private Right right = Right.USER;

    @Column(name = "secret_question")
    private String secretQuestion = "";

    @Column(name = "secret_answer")
    private String secretAnswer = "";

    @Column(name = "subscription_end", converter = SqlTimestampToJodaInstant.class)
    private Instant subscriptionEnd;

    @NotNull
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(@NotNull Object id) {
        this.id = (Long) id;
    }

    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    @NotNull
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(@NotNull String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @NotNull
    public String getSalt() {
        return salt;
    }

    public void setSalt(@NotNull String salt) {
        this.salt = salt;
    }

    @NotNull
    public String getNickname() {
        return nickname;
    }

    public void setNickname(@NotNull String nickname) {
        this.nickname = nickname;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    @NotNull
    public Right getRight() {
        return right;
    }

    public boolean isBanned() {
        return right == Right.BANNED;
    }

    public boolean hasRights() {
        return right.ordinal() > Right.USER.ordinal();
    }

    public void setRight(@NotNull Right right) {
        this.right = right;
    }

    @NotNull
    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(@NotNull String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    @NotNull
    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(@NotNull String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    public Instant getSubscriptionEnd() {
        return subscriptionEnd;
    }

    public void setSubscriptionEnd(Instant subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
    }
}
