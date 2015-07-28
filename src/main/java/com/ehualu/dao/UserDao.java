package com.ehualu.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ehualu.bo.User;

/**
 * @ClassName: UserDAO 
 * @Description: UserDAO
 * @author tianli 
 * @date 2015-1-21 14:37:23 
 */
@Repository
@Transactional(readOnly = true)
public class UserDao extends BaseDao<User, Integer>{
	
}
