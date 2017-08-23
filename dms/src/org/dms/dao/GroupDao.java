package org.dms.dao;

import org.dms.idao.IGroupDao;
import org.dms.model.Group;
import org.springframework.stereotype.Repository;

@Repository("groupDao")
public class GroupDao extends BaseDao<Group> implements IGroupDao {

}
