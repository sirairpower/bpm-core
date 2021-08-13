package com.bpm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
@Accessors(chain = true)
@Table(name = "shopee_product_info")
public class ShopeeProductInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "category_name", nullable = false)
  private String categoryName;

  @EqualsAndHashCode.Include
  @Column(name = "subject", nullable = false)
  private String subject;

  @Column(name = "link", nullable = false)
  private String link;

  @Column(name = "variant_prod_true", nullable = false)
  private Boolean variantProdTrue;

  @Column(name = "img_links")
  private String imgLinks;

  @Column(name = "inventory_quantity")
  private Integer inventoryQuantity;

  @Column(name = "description")
  private String desc;

  @Column(name = "create_user", nullable = false)
  private String createUser;

  @Column(name = "create_date", nullable = false)
  private Date createDate;

  @Column(name = "update_user")
  private String updateUser;

  @Column(name = "update_date")
  private Date updateDate;

  @ToString.Exclude
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopeeProductInfo")
  private List<ShopeeVariantProd> shopeeVariantProds;

}
