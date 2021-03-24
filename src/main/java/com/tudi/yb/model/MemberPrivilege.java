package com.tudi.yb.model;

import com.tudi.yb.model.MemberPrivilege.MemberPrivilegePK;
import com.tudi.yb.model.TemplateMrd.TemplateMrdPK;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "member_privilege")
@IdClass(MemberPrivilegePK.class)
public class MemberPrivilege implements Serializable {
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  class MemberPrivilegePK implements  Serializable{
    private Long memberId;
    private Long privilegeId;
  }

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "member_id", nullable = false)
  private Long memberId;

  @Id
  @Column(name = "privilege_id", nullable = false)
  private Long privilegeId;

}
