package com.dh.narihair.repo;

import com.dh.narihair.domain.UserDTO;
import com.dh.narihair.entity.QReservation;
import com.dh.narihair.entity.QUser;
import com.dh.narihair.entity.User;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilderFactory;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class UserRepoExImpl implements UserRepoEx{
    final private JPAQueryFactory factory;

    public Page<UserDTO> getUserList(UserDTO param, Pageable page){
        QUser user = QUser.user;
        QReservation res = QReservation.reservation;

        BooleanBuilder where = new BooleanBuilder();
        where.and(user.delAt.eq(false));
        if(!StringUtils.isEmpty(param.getName())){
            where.and(user.name.contains(param.getName()));
        }
        if(!StringUtils.isEmpty(param.getPhone())){
            where.and(user.phone.contains(param.getPhone()));
        }
        if(!StringUtils.isEmpty(param.getStartDate())){
            where.and(user.createdAt.goe(param.getStartDate().atTime(0,0)));
        }
        if(!StringUtils.isEmpty(param.getEndDate())){
            where.and(user.createdAt.loe(param.getEndDate().atTime(23,59)));
        }

        JPAQuery<UserDTO> query = null;
        query = factory.select(
                    Projections.fields(UserDTO.class,
                            user.seq,
                            user.name,
                            user.phone,
                            user.memo,
                            user.createdAt,
                            ExpressionUtils.as(
                                    JPAExpressions.select(res.count())
                                            .from(res)
                                            .where(res.delAt.eq(false).and(res.user.eq(user))),
                                    "resCount")

                    )
                )
                .from(user)
                .where(where)
                .offset(page.getOffset())
                .orderBy(user.seq.desc())
                .limit(page.getPageSize());

        QueryResults<UserDTO> result = query.fetchResults();
        return new PageImpl<>(result.getResults(),page,result.getTotal());
    }
}
