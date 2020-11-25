package com.tdge.peers.model;

import com.tdge.peers.model.enums.ShareType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Shares {
    @Id
    private Long shareId;

    private String shareName;

    private String shareDescription;

    private ShareType shareType;

    @OneToOne
    private Post postId;
}
