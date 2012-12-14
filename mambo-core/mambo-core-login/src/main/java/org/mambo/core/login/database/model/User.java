package org.mambo.core.login.database.model;

import org.jetbrains.annotations.NotNull;
import org.mambo.shared.database.annotations.Column;
import org.mambo.shared.database.annotations.Id;
import org.mambo.shared.database.annotations.Table;
import org.mambo.shared.database.impl.Model;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 09/12/12
 * Time: 00:09
 */
@Table("users")
public class User extends Model<User> {
    @Id
    @Column
    private Long id = 0L;

    @Column
    private String username = "";

    @Column(name="password_hash")
    private String passwordHash = "";

    @Column
    private String nickname = "";

    @Column
    private String email = "";

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
}
