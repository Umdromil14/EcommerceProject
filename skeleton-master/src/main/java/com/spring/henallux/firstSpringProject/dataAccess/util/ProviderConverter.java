package com.spring.henallux.firstSpringProject.dataAccess.util;

import com.spring.henallux.firstSpringProject.dataAccess.entity.*;
import com.spring.henallux.firstSpringProject.model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
public class ProviderConverter {
    private final Mapper mapper = new DozerBeanMapper();
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public CategoryTranslationEntity categoryTranslationModelToCategoryTranslationEntity(CategoryTranslation categoryTranslation){
        return mapper.map(categoryTranslation, CategoryTranslationEntity.class);
    }

    public CategoryTranslation categoryTranslationEntityToCategoryTranslationModel(CategoryTranslationEntity categoryTranslationEntity){
        return mapper.map(categoryTranslationEntity, CategoryTranslation.class);
    }

    public ProductEntity productModelToProductEntity(Product product){
        return mapper.map(product, ProductEntity.class);
    }
    public Product productEntityToProductModel(ProductEntity productEntity){
        Product product= mapper.map(productEntity, Product.class);
        product.setPrice(productEntity.getActualUnitPrice());
        product.setID(productEntity.getId());
        return product;
    }


    public UserEntity userModelToUserEntity(User user){
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity.setAuthorities(user.getAuthoritiesToString());
        userEntity.setNonExpired(user.isAccountNonExpired());
        userEntity.setNonLocked(user.isAccountNonLocked());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity){
        User user = mapper.map(userEntity, User.class);
        user.setNonExpired(userEntity.getNonExpired());
        user.setNonLocked(userEntity.getNonLocked());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        user.setAuthorities(userEntity.getAuthorities());
        return user;
    }

    public Voucher voucherEntityToVoucherModel(VoucherEntity voucherEntity){
        Voucher voucher = mapper.map(voucherEntity, Voucher.class);
        voucher.setCodeCategory(voucherEntity.getCategory());
        return voucher;
    }

    public VoucherEntity voucherModelToVoucherEntity(Voucher voucher){
        return mapper.map(voucher, VoucherEntity.class);
    }

    public OrderEntity orderModelToOrderEntity(Order order){
        return mapper.map(order, OrderEntity.class);
    }

    public TransactionDetailEntity transactionDetailModelToTransactionDetailEntity(TransactionDetail transactionDetail){
        return mapper.map(transactionDetail, TransactionDetailEntity.class);
    }
    
    public ReductionEntity reductionModelToReductionEntity(Reduction reduction){
        return mapper.map(reduction, ReductionEntity.class);
    }
}
