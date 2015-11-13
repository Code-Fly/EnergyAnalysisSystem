package com.flycode.log.mapper;

import com.flycode.log.entity.TabLog;
import com.flycode.log.entity.TabLogExample;
import java.util.List;

public interface TabLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_log
     *
     * @mbggenerated Fri Nov 13 11:14:55 CST 2015
     */
    int deleteByPrimaryKey(Integer logID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_log
     *
     * @mbggenerated Fri Nov 13 11:14:55 CST 2015
     */
    int insert(TabLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_log
     *
     * @mbggenerated Fri Nov 13 11:14:55 CST 2015
     */
    int insertSelective(TabLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_log
     *
     * @mbggenerated Fri Nov 13 11:14:55 CST 2015
     */
    List<TabLog> selectByExample(TabLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_log
     *
     * @mbggenerated Fri Nov 13 11:14:55 CST 2015
     */
    TabLog selectByPrimaryKey(Integer logID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_log
     *
     * @mbggenerated Fri Nov 13 11:14:55 CST 2015
     */
    int updateByPrimaryKeySelective(TabLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_log
     *
     * @mbggenerated Fri Nov 13 11:14:55 CST 2015
     */
    int updateByPrimaryKey(TabLog record);
}