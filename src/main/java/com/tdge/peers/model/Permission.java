package com.tdge.peers.model;

import com.tdge.peers.model.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    @OneToOne
    private User userRole;

    private PermissionType permissionTitle;

    private String permissionModule;

    private String permissionDescription;
}
