package com.ueumd.tech.entity;

import com.ueumd.tech.domain.ai.AiRole;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Po 实际开发中不需要这么多属性
 */

@Data
@NoArgsConstructor
public class AiRoleListPo {
    private String username;
    private String role;

    public AiRoleListPo(AiRole aiRole) {
        this.username = aiRole.getUsername();
        this.role = aiRole.getRole();
    }
}
