package com.tt.entity;

import java.util.ArrayList;
import java.util.List;

public class QFangLoudongExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QFangLoudongExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQIdIsNull() {
            addCriterion("q_id is null");
            return (Criteria) this;
        }

        public Criteria andQIdIsNotNull() {
            addCriterion("q_id is not null");
            return (Criteria) this;
        }

        public Criteria andQIdEqualTo(String value) {
            addCriterion("q_id =", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotEqualTo(String value) {
            addCriterion("q_id <>", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThan(String value) {
            addCriterion("q_id >", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThanOrEqualTo(String value) {
            addCriterion("q_id >=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThan(String value) {
            addCriterion("q_id <", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThanOrEqualTo(String value) {
            addCriterion("q_id <=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLike(String value) {
            addCriterion("q_id like", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotLike(String value) {
            addCriterion("q_id not like", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdIn(List<String> values) {
            addCriterion("q_id in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotIn(List<String> values) {
            addCriterion("q_id not in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdBetween(String value1, String value2) {
            addCriterion("q_id between", value1, value2, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotBetween(String value1, String value2) {
            addCriterion("q_id not between", value1, value2, "qId");
            return (Criteria) this;
        }

        public Criteria andInternalIdIsNull() {
            addCriterion("internal_id is null");
            return (Criteria) this;
        }

        public Criteria andInternalIdIsNotNull() {
            addCriterion("internal_id is not null");
            return (Criteria) this;
        }

        public Criteria andInternalIdEqualTo(String value) {
            addCriterion("internal_id =", value, "internalId");
            return (Criteria) this;
        }

        public Criteria andInternalIdNotEqualTo(String value) {
            addCriterion("internal_id <>", value, "internalId");
            return (Criteria) this;
        }

        public Criteria andInternalIdGreaterThan(String value) {
            addCriterion("internal_id >", value, "internalId");
            return (Criteria) this;
        }

        public Criteria andInternalIdGreaterThanOrEqualTo(String value) {
            addCriterion("internal_id >=", value, "internalId");
            return (Criteria) this;
        }

        public Criteria andInternalIdLessThan(String value) {
            addCriterion("internal_id <", value, "internalId");
            return (Criteria) this;
        }

        public Criteria andInternalIdLessThanOrEqualTo(String value) {
            addCriterion("internal_id <=", value, "internalId");
            return (Criteria) this;
        }

        public Criteria andInternalIdLike(String value) {
            addCriterion("internal_id like", value, "internalId");
            return (Criteria) this;
        }

        public Criteria andInternalIdNotLike(String value) {
            addCriterion("internal_id not like", value, "internalId");
            return (Criteria) this;
        }

        public Criteria andInternalIdIn(List<String> values) {
            addCriterion("internal_id in", values, "internalId");
            return (Criteria) this;
        }

        public Criteria andInternalIdNotIn(List<String> values) {
            addCriterion("internal_id not in", values, "internalId");
            return (Criteria) this;
        }

        public Criteria andInternalIdBetween(String value1, String value2) {
            addCriterion("internal_id between", value1, value2, "internalId");
            return (Criteria) this;
        }

        public Criteria andInternalIdNotBetween(String value1, String value2) {
            addCriterion("internal_id not between", value1, value2, "internalId");
            return (Criteria) this;
        }

        public Criteria andBuildIdIsNull() {
            addCriterion("build_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildIdIsNotNull() {
            addCriterion("build_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildIdEqualTo(String value) {
            addCriterion("build_id =", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotEqualTo(String value) {
            addCriterion("build_id <>", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThan(String value) {
            addCriterion("build_id >", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThanOrEqualTo(String value) {
            addCriterion("build_id >=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThan(String value) {
            addCriterion("build_id <", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThanOrEqualTo(String value) {
            addCriterion("build_id <=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLike(String value) {
            addCriterion("build_id like", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotLike(String value) {
            addCriterion("build_id not like", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdIn(List<String> values) {
            addCriterion("build_id in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotIn(List<String> values) {
            addCriterion("build_id not in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdBetween(String value1, String value2) {
            addCriterion("build_id between", value1, value2, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotBetween(String value1, String value2) {
            addCriterion("build_id not between", value1, value2, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildNameIsNull() {
            addCriterion("build_name is null");
            return (Criteria) this;
        }

        public Criteria andBuildNameIsNotNull() {
            addCriterion("build_name is not null");
            return (Criteria) this;
        }

        public Criteria andBuildNameEqualTo(String value) {
            addCriterion("build_name =", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotEqualTo(String value) {
            addCriterion("build_name <>", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameGreaterThan(String value) {
            addCriterion("build_name >", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameGreaterThanOrEqualTo(String value) {
            addCriterion("build_name >=", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLessThan(String value) {
            addCriterion("build_name <", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLessThanOrEqualTo(String value) {
            addCriterion("build_name <=", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameLike(String value) {
            addCriterion("build_name like", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotLike(String value) {
            addCriterion("build_name not like", value, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameIn(List<String> values) {
            addCriterion("build_name in", values, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotIn(List<String> values) {
            addCriterion("build_name not in", values, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameBetween(String value1, String value2) {
            addCriterion("build_name between", value1, value2, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildNameNotBetween(String value1, String value2) {
            addCriterion("build_name not between", value1, value2, "buildName");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameIsNull() {
            addCriterion("build_register_name is null");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameIsNotNull() {
            addCriterion("build_register_name is not null");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameEqualTo(String value) {
            addCriterion("build_register_name =", value, "buildRegisterName");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameNotEqualTo(String value) {
            addCriterion("build_register_name <>", value, "buildRegisterName");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameGreaterThan(String value) {
            addCriterion("build_register_name >", value, "buildRegisterName");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameGreaterThanOrEqualTo(String value) {
            addCriterion("build_register_name >=", value, "buildRegisterName");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameLessThan(String value) {
            addCriterion("build_register_name <", value, "buildRegisterName");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameLessThanOrEqualTo(String value) {
            addCriterion("build_register_name <=", value, "buildRegisterName");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameLike(String value) {
            addCriterion("build_register_name like", value, "buildRegisterName");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameNotLike(String value) {
            addCriterion("build_register_name not like", value, "buildRegisterName");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameIn(List<String> values) {
            addCriterion("build_register_name in", values, "buildRegisterName");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameNotIn(List<String> values) {
            addCriterion("build_register_name not in", values, "buildRegisterName");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameBetween(String value1, String value2) {
            addCriterion("build_register_name between", value1, value2, "buildRegisterName");
            return (Criteria) this;
        }

        public Criteria andBuildRegisterNameNotBetween(String value1, String value2) {
            addCriterion("build_register_name not between", value1, value2, "buildRegisterName");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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