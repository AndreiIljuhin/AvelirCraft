package com.avelircraft.models;

import com.avelircraft.models.stats.MMOCore;
import com.avelircraft.models.stats.PlayTime;
import com.avelircraft.models.stats.UUIDAbstract;

import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;

@Entity
@Table(name = "luckperms_players")
public class Role extends UUIDAbstract implements Serializable {

    @Column(name = "primary_group")
    private String role;

    @OneToOne(mappedBy = "uuid", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private MMOCore mmoCore;

    public Role() {
    }

    public Role(User user) {
        super( System.currentTimeMillis() + "default", user);
        role = "default";
    }

    public Role(String uuid, User user, String role) {
        super( System.currentTimeMillis() + "default", user);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }

    @Transactional
    public MMOCore getMmoCore() { return mmoCore; }
}
