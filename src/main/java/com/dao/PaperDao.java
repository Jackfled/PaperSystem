/**
 * 数据访问接口，和数据库打交道
 */
package com.dao;

import com.pojo.Paper;

import java.util.List;

public interface PaperDao {
    int addPaper(Paper paper);

    int deletePaperById(long id);

    int updatePaper(Paper paper);

    Paper queryById(long id);

    List<Paper> queryAllPaper();


}
