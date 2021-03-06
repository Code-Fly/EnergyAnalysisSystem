package com.flycode.area.entity;

import java.util.ArrayList;
import java.util.List;

public class TabAreaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    public TabAreaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andInfoIDIsNull() {
            addCriterion("infoID is null");
            return (Criteria) this;
        }

        public Criteria andInfoIDIsNotNull() {
            addCriterion("infoID is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIDEqualTo(String value) {
            addCriterion("infoID =", value, "infoID");
            return (Criteria) this;
        }

        public Criteria andInfoIDNotEqualTo(String value) {
            addCriterion("infoID <>", value, "infoID");
            return (Criteria) this;
        }

        public Criteria andInfoIDGreaterThan(String value) {
            addCriterion("infoID >", value, "infoID");
            return (Criteria) this;
        }

        public Criteria andInfoIDGreaterThanOrEqualTo(String value) {
            addCriterion("infoID >=", value, "infoID");
            return (Criteria) this;
        }

        public Criteria andInfoIDLessThan(String value) {
            addCriterion("infoID <", value, "infoID");
            return (Criteria) this;
        }

        public Criteria andInfoIDLessThanOrEqualTo(String value) {
            addCriterion("infoID <=", value, "infoID");
            return (Criteria) this;
        }

        public Criteria andInfoIDLike(String value) {
            addCriterion("infoID like", value, "infoID");
            return (Criteria) this;
        }

        public Criteria andInfoIDNotLike(String value) {
            addCriterion("infoID not like", value, "infoID");
            return (Criteria) this;
        }

        public Criteria andInfoIDIn(List<String> values) {
            addCriterion("infoID in", values, "infoID");
            return (Criteria) this;
        }

        public Criteria andInfoIDNotIn(List<String> values) {
            addCriterion("infoID not in", values, "infoID");
            return (Criteria) this;
        }

        public Criteria andInfoIDBetween(String value1, String value2) {
            addCriterion("infoID between", value1, value2, "infoID");
            return (Criteria) this;
        }

        public Criteria andInfoIDNotBetween(String value1, String value2) {
            addCriterion("infoID not between", value1, value2, "infoID");
            return (Criteria) this;
        }

        public Criteria andNmIsNull() {
            addCriterion("nm is null");
            return (Criteria) this;
        }

        public Criteria andNmIsNotNull() {
            addCriterion("nm is not null");
            return (Criteria) this;
        }

        public Criteria andNmEqualTo(String value) {
            addCriterion("nm =", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmNotEqualTo(String value) {
            addCriterion("nm <>", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmGreaterThan(String value) {
            addCriterion("nm >", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmGreaterThanOrEqualTo(String value) {
            addCriterion("nm >=", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmLessThan(String value) {
            addCriterion("nm <", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmLessThanOrEqualTo(String value) {
            addCriterion("nm <=", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmLike(String value) {
            addCriterion("nm like", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmNotLike(String value) {
            addCriterion("nm not like", value, "nm");
            return (Criteria) this;
        }

        public Criteria andNmIn(List<String> values) {
            addCriterion("nm in", values, "nm");
            return (Criteria) this;
        }

        public Criteria andNmNotIn(List<String> values) {
            addCriterion("nm not in", values, "nm");
            return (Criteria) this;
        }

        public Criteria andNmBetween(String value1, String value2) {
            addCriterion("nm between", value1, value2, "nm");
            return (Criteria) this;
        }

        public Criteria andNmNotBetween(String value1, String value2) {
            addCriterion("nm not between", value1, value2, "nm");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andMemIsNull() {
            addCriterion("mem is null");
            return (Criteria) this;
        }

        public Criteria andMemIsNotNull() {
            addCriterion("mem is not null");
            return (Criteria) this;
        }

        public Criteria andMemEqualTo(String value) {
            addCriterion("mem =", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotEqualTo(String value) {
            addCriterion("mem <>", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemGreaterThan(String value) {
            addCriterion("mem >", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemGreaterThanOrEqualTo(String value) {
            addCriterion("mem >=", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLessThan(String value) {
            addCriterion("mem <", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLessThanOrEqualTo(String value) {
            addCriterion("mem <=", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLike(String value) {
            addCriterion("mem like", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotLike(String value) {
            addCriterion("mem not like", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemIn(List<String> values) {
            addCriterion("mem in", values, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotIn(List<String> values) {
            addCriterion("mem not in", values, "mem");
            return (Criteria) this;
        }

        public Criteria andMemBetween(String value1, String value2) {
            addCriterion("mem between", value1, value2, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotBetween(String value1, String value2) {
            addCriterion("mem not between", value1, value2, "mem");
            return (Criteria) this;
        }

        public Criteria andFatherIDIsNull() {
            addCriterion("fatherID is null");
            return (Criteria) this;
        }

        public Criteria andFatherIDIsNotNull() {
            addCriterion("fatherID is not null");
            return (Criteria) this;
        }

        public Criteria andFatherIDEqualTo(String value) {
            addCriterion("fatherID =", value, "fatherID");
            return (Criteria) this;
        }

        public Criteria andFatherIDNotEqualTo(String value) {
            addCriterion("fatherID <>", value, "fatherID");
            return (Criteria) this;
        }

        public Criteria andFatherIDGreaterThan(String value) {
            addCriterion("fatherID >", value, "fatherID");
            return (Criteria) this;
        }

        public Criteria andFatherIDGreaterThanOrEqualTo(String value) {
            addCriterion("fatherID >=", value, "fatherID");
            return (Criteria) this;
        }

        public Criteria andFatherIDLessThan(String value) {
            addCriterion("fatherID <", value, "fatherID");
            return (Criteria) this;
        }

        public Criteria andFatherIDLessThanOrEqualTo(String value) {
            addCriterion("fatherID <=", value, "fatherID");
            return (Criteria) this;
        }

        public Criteria andFatherIDLike(String value) {
            addCriterion("fatherID like", value, "fatherID");
            return (Criteria) this;
        }

        public Criteria andFatherIDNotLike(String value) {
            addCriterion("fatherID not like", value, "fatherID");
            return (Criteria) this;
        }

        public Criteria andFatherIDIn(List<String> values) {
            addCriterion("fatherID in", values, "fatherID");
            return (Criteria) this;
        }

        public Criteria andFatherIDNotIn(List<String> values) {
            addCriterion("fatherID not in", values, "fatherID");
            return (Criteria) this;
        }

        public Criteria andFatherIDBetween(String value1, String value2) {
            addCriterion("fatherID between", value1, value2, "fatherID");
            return (Criteria) this;
        }

        public Criteria andFatherIDNotBetween(String value1, String value2) {
            addCriterion("fatherID not between", value1, value2, "fatherID");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tab_area
     *
     * @mbggenerated do_not_delete_during_merge Thu Nov 12 13:36:25 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tab_area
     *
     * @mbggenerated Thu Nov 12 13:36:25 CST 2015
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}