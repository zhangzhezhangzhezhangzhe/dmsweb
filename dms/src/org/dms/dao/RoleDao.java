package org.dms.dao;


import org.dms.idao.IRoleDao;
import org.dms.model.Role;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDao extends BaseDao<Role> implements IRoleDao {

}
