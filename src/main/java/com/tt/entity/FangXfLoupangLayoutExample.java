package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FangXfLoupangLayoutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FangXfLoupangLayoutExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSharesAreaIsNull() {
            addCriterion("shares_area is null");
            return (Criteria) this;
        }

        public Criteria andSharesAreaIsNotNull() {
            addCriterion("shares_area is not null");
            return (Criteria) this;
        }

        public Criteria andSharesAreaEqualTo(String value) {
            addCriterion("shares_area =", value, "sharesArea");
            return (Criteria) this;
        }

        public Criteria andSharesAreaNotEqualTo(String value) {
            addCriterion("shares_area <>", value, "sharesArea");
            return (Criteria) this;
        }

        public Criteria andSharesAreaGreaterThan(String value) {
            addCriterion("shares_area >", value, "sharesArea");
            return (Criteria) this;
        }

        public Criteria andSharesAreaGreaterThanOrEqualTo(String value) {
            addCriterion("shares_area >=", value, "sharesArea");
            return (Criteria) this;
        }

        public Criteria andSharesAreaLessThan(String value) {
            addCriterion("shares_area <", value, "sharesArea");
            return (Criteria) this;
        }

        public Criteria andSharesAreaLessThanOrEqualTo(String value) {
            addCriterion("shares_area <=", value, "sharesArea");
            return (Criteria) this;
        }

        public Criteria andSharesAreaLike(String value) {
            addCriterion("shares_area like", value, "sharesArea");
            return (Criteria) this;
        }

        public Criteria andSharesAreaNotLike(String value) {
            addCriterion("shares_area not like", value, "sharesArea");
            return (Criteria) this;
        }

        public Criteria andSharesAreaIn(List<String> values) {
            addCriterion("shares_area in", values, "sharesArea");
            return (Criteria) this;
        }

        public Criteria andSharesAreaNotIn(List<String> values) {
            addCriterion("shares_area not in", values, "sharesArea");
            return (Criteria) this;
        }

        public Criteria andSharesAreaBetween(String value1, String value2) {
            addCriterion("shares_area between", value1, value2, "sharesArea");
            return (Criteria) this;
        }

        public Criteria andSharesAreaNotBetween(String value1, String value2) {
            addCriterion("shares_area not between", value1, value2, "sharesArea");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIdIsNull() {
            addCriterion("title_id is null");
            return (Criteria) this;
        }

        public Criteria andTitleIdIsNotNull() {
            addCriterion("title_id is not null");
            return (Criteria) this;
        }

        public Criteria andTitleIdEqualTo(String value) {
            addCriterion("title_id =", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotEqualTo(String value) {
            addCriterion("title_id <>", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThan(String value) {
            addCriterion("title_id >", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThanOrEqualTo(String value) {
            addCriterion("title_id >=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThan(String value) {
            addCriterion("title_id <", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThanOrEqualTo(String value) {
            addCriterion("title_id <=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLike(String value) {
            addCriterion("title_id like", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotLike(String value) {
            addCriterion("title_id not like", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdIn(List<String> values) {
            addCriterion("title_id in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotIn(List<String> values) {
            addCriterion("title_id not in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdBetween(String value1, String value2) {
            addCriterion("title_id between", value1, value2, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotBetween(String value1, String value2) {
            addCriterion("title_id not between", value1, value2, "titleId");
            return (Criteria) this;
        }

        public Criteria andDetailPcIsNull() {
            addCriterion("detail_pc is null");
            return (Criteria) this;
        }

        public Criteria andDetailPcIsNotNull() {
            addCriterion("detail_pc is not null");
            return (Criteria) this;
        }

        public Criteria andDetailPcEqualTo(String value) {
            addCriterion("detail_pc =", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcNotEqualTo(String value) {
            addCriterion("detail_pc <>", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcGreaterThan(String value) {
            addCriterion("detail_pc >", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcGreaterThanOrEqualTo(String value) {
            addCriterion("detail_pc >=", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcLessThan(String value) {
            addCriterion("detail_pc <", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcLessThanOrEqualTo(String value) {
            addCriterion("detail_pc <=", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcLike(String value) {
            addCriterion("detail_pc like", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcNotLike(String value) {
            addCriterion("detail_pc not like", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcIn(List<String> values) {
            addCriterion("detail_pc in", values, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcNotIn(List<String> values) {
            addCriterion("detail_pc not in", values, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcBetween(String value1, String value2) {
            addCriterion("detail_pc between", value1, value2, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcNotBetween(String value1, String value2) {
            addCriterion("detail_pc not between", value1, value2, "detailPc");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlIsNull() {
            addCriterion("huxing_url is null");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlIsNotNull() {
            addCriterion("huxing_url is not null");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlEqualTo(String value) {
            addCriterion("huxing_url =", value, "huxingUrl");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlNotEqualTo(String value) {
            addCriterion("huxing_url <>", value, "huxingUrl");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlGreaterThan(String value) {
            addCriterion("huxing_url >", value, "huxingUrl");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlGreaterThanOrEqualTo(String value) {
            addCriterion("huxing_url >=", value, "huxingUrl");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlLessThan(String value) {
            addCriterion("huxing_url <", value, "huxingUrl");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlLessThanOrEqualTo(String value) {
            addCriterion("huxing_url <=", value, "huxingUrl");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlLike(String value) {
            addCriterion("huxing_url like", value, "huxingUrl");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlNotLike(String value) {
            addCriterion("huxing_url not like", value, "huxingUrl");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlIn(List<String> values) {
            addCriterion("huxing_url in", values, "huxingUrl");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlNotIn(List<String> values) {
            addCriterion("huxing_url not in", values, "huxingUrl");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlBetween(String value1, String value2) {
            addCriterion("huxing_url between", value1, value2, "huxingUrl");
            return (Criteria) this;
        }

        public Criteria andHuxingUrlNotBetween(String value1, String value2) {
            addCriterion("huxing_url not between", value1, value2, "huxingUrl");
            return (Criteria) this;
        }

        public Criteria andHuxingIdIsNull() {
            addCriterion("huxing_id is null");
            return (Criteria) this;
        }

        public Criteria andHuxingIdIsNotNull() {
            addCriterion("huxing_id is not null");
            return (Criteria) this;
        }

        public Criteria andHuxingIdEqualTo(String value) {
            addCriterion("huxing_id =", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdNotEqualTo(String value) {
            addCriterion("huxing_id <>", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdGreaterThan(String value) {
            addCriterion("huxing_id >", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdGreaterThanOrEqualTo(String value) {
            addCriterion("huxing_id >=", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdLessThan(String value) {
            addCriterion("huxing_id <", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdLessThanOrEqualTo(String value) {
            addCriterion("huxing_id <=", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdLike(String value) {
            addCriterion("huxing_id like", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdNotLike(String value) {
            addCriterion("huxing_id not like", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdIn(List<String> values) {
            addCriterion("huxing_id in", values, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdNotIn(List<String> values) {
            addCriterion("huxing_id not in", values, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdBetween(String value1, String value2) {
            addCriterion("huxing_id between", value1, value2, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdNotBetween(String value1, String value2) {
            addCriterion("huxing_id not between", value1, value2, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingNameIsNull() {
            addCriterion("huxing_name is null");
            return (Criteria) this;
        }

        public Criteria andHuxingNameIsNotNull() {
            addCriterion("huxing_name is not null");
            return (Criteria) this;
        }

        public Criteria andHuxingNameEqualTo(String value) {
            addCriterion("huxing_name =", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameNotEqualTo(String value) {
            addCriterion("huxing_name <>", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameGreaterThan(String value) {
            addCriterion("huxing_name >", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameGreaterThanOrEqualTo(String value) {
            addCriterion("huxing_name >=", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameLessThan(String value) {
            addCriterion("huxing_name <", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameLessThanOrEqualTo(String value) {
            addCriterion("huxing_name <=", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameLike(String value) {
            addCriterion("huxing_name like", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameNotLike(String value) {
            addCriterion("huxing_name not like", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameIn(List<String> values) {
            addCriterion("huxing_name in", values, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameNotIn(List<String> values) {
            addCriterion("huxing_name not in", values, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameBetween(String value1, String value2) {
            addCriterion("huxing_name between", value1, value2, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameNotBetween(String value1, String value2) {
            addCriterion("huxing_name not between", value1, value2, "huxingName");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaIsNull() {
            addCriterion("current_area is null");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaIsNotNull() {
            addCriterion("current_area is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaEqualTo(String value) {
            addCriterion("current_area =", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaNotEqualTo(String value) {
            addCriterion("current_area <>", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaGreaterThan(String value) {
            addCriterion("current_area >", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaGreaterThanOrEqualTo(String value) {
            addCriterion("current_area >=", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaLessThan(String value) {
            addCriterion("current_area <", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaLessThanOrEqualTo(String value) {
            addCriterion("current_area <=", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaLike(String value) {
            addCriterion("current_area like", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaNotLike(String value) {
            addCriterion("current_area not like", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaIn(List<String> values) {
            addCriterion("current_area in", values, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaNotIn(List<String> values) {
            addCriterion("current_area not in", values, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaBetween(String value1, String value2) {
            addCriterion("current_area between", value1, value2, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaNotBetween(String value1, String value2) {
            addCriterion("current_area not between", value1, value2, "currentArea");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusIsNull() {
            addCriterion("huxing_status is null");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusIsNotNull() {
            addCriterion("huxing_status is not null");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusEqualTo(String value) {
            addCriterion("huxing_status =", value, "huxingStatus");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusNotEqualTo(String value) {
            addCriterion("huxing_status <>", value, "huxingStatus");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusGreaterThan(String value) {
            addCriterion("huxing_status >", value, "huxingStatus");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusGreaterThanOrEqualTo(String value) {
            addCriterion("huxing_status >=", value, "huxingStatus");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusLessThan(String value) {
            addCriterion("huxing_status <", value, "huxingStatus");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusLessThanOrEqualTo(String value) {
            addCriterion("huxing_status <=", value, "huxingStatus");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusLike(String value) {
            addCriterion("huxing_status like", value, "huxingStatus");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusNotLike(String value) {
            addCriterion("huxing_status not like", value, "huxingStatus");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusIn(List<String> values) {
            addCriterion("huxing_status in", values, "huxingStatus");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusNotIn(List<String> values) {
            addCriterion("huxing_status not in", values, "huxingStatus");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusBetween(String value1, String value2) {
            addCriterion("huxing_status between", value1, value2, "huxingStatus");
            return (Criteria) this;
        }

        public Criteria andHuxingStatusNotBetween(String value1, String value2) {
            addCriterion("huxing_status not between", value1, value2, "huxingStatus");
            return (Criteria) this;
        }

        public Criteria andAvepriceIsNull() {
            addCriterion("aveprice is null");
            return (Criteria) this;
        }

        public Criteria andAvepriceIsNotNull() {
            addCriterion("aveprice is not null");
            return (Criteria) this;
        }

        public Criteria andAvepriceEqualTo(String value) {
            addCriterion("aveprice =", value, "aveprice");
            return (Criteria) this;
        }

        public Criteria andAvepriceNotEqualTo(String value) {
            addCriterion("aveprice <>", value, "aveprice");
            return (Criteria) this;
        }

        public Criteria andAvepriceGreaterThan(String value) {
            addCriterion("aveprice >", value, "aveprice");
            return (Criteria) this;
        }

        public Criteria andAvepriceGreaterThanOrEqualTo(String value) {
            addCriterion("aveprice >=", value, "aveprice");
            return (Criteria) this;
        }

        public Criteria andAvepriceLessThan(String value) {
            addCriterion("aveprice <", value, "aveprice");
            return (Criteria) this;
        }

        public Criteria andAvepriceLessThanOrEqualTo(String value) {
            addCriterion("aveprice <=", value, "aveprice");
            return (Criteria) this;
        }

        public Criteria andAvepriceLike(String value) {
            addCriterion("aveprice like", value, "aveprice");
            return (Criteria) this;
        }

        public Criteria andAvepriceNotLike(String value) {
            addCriterion("aveprice not like", value, "aveprice");
            return (Criteria) this;
        }

        public Criteria andAvepriceIn(List<String> values) {
            addCriterion("aveprice in", values, "aveprice");
            return (Criteria) this;
        }

        public Criteria andAvepriceNotIn(List<String> values) {
            addCriterion("aveprice not in", values, "aveprice");
            return (Criteria) this;
        }

        public Criteria andAvepriceBetween(String value1, String value2) {
            addCriterion("aveprice between", value1, value2, "aveprice");
            return (Criteria) this;
        }

        public Criteria andAvepriceNotBetween(String value1, String value2) {
            addCriterion("aveprice not between", value1, value2, "aveprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNull() {
            addCriterion("totalprice is null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNotNull() {
            addCriterion("totalprice is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceEqualTo(String value) {
            addCriterion("totalprice =", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotEqualTo(String value) {
            addCriterion("totalprice <>", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThan(String value) {
            addCriterion("totalprice >", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThanOrEqualTo(String value) {
            addCriterion("totalprice >=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThan(String value) {
            addCriterion("totalprice <", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThanOrEqualTo(String value) {
            addCriterion("totalprice <=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLike(String value) {
            addCriterion("totalprice like", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotLike(String value) {
            addCriterion("totalprice not like", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIn(List<String> values) {
            addCriterion("totalprice in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotIn(List<String> values) {
            addCriterion("totalprice not in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceBetween(String value1, String value2) {
            addCriterion("totalprice between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotBetween(String value1, String value2) {
            addCriterion("totalprice not between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andBuildingDistIsNull() {
            addCriterion("building_dist is null");
            return (Criteria) this;
        }

        public Criteria andBuildingDistIsNotNull() {
            addCriterion("building_dist is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingDistEqualTo(String value) {
            addCriterion("building_dist =", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistNotEqualTo(String value) {
            addCriterion("building_dist <>", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistGreaterThan(String value) {
            addCriterion("building_dist >", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistGreaterThanOrEqualTo(String value) {
            addCriterion("building_dist >=", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistLessThan(String value) {
            addCriterion("building_dist <", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistLessThanOrEqualTo(String value) {
            addCriterion("building_dist <=", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistLike(String value) {
            addCriterion("building_dist like", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistNotLike(String value) {
            addCriterion("building_dist not like", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistIn(List<String> values) {
            addCriterion("building_dist in", values, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistNotIn(List<String> values) {
            addCriterion("building_dist not in", values, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistBetween(String value1, String value2) {
            addCriterion("building_dist between", value1, value2, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistNotBetween(String value1, String value2) {
            addCriterion("building_dist not between", value1, value2, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("score like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("score not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andFrameImageIsNull() {
            addCriterion("frame_image is null");
            return (Criteria) this;
        }

        public Criteria andFrameImageIsNotNull() {
            addCriterion("frame_image is not null");
            return (Criteria) this;
        }

        public Criteria andFrameImageEqualTo(String value) {
            addCriterion("frame_image =", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageNotEqualTo(String value) {
            addCriterion("frame_image <>", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageGreaterThan(String value) {
            addCriterion("frame_image >", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageGreaterThanOrEqualTo(String value) {
            addCriterion("frame_image >=", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageLessThan(String value) {
            addCriterion("frame_image <", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageLessThanOrEqualTo(String value) {
            addCriterion("frame_image <=", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageLike(String value) {
            addCriterion("frame_image like", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageNotLike(String value) {
            addCriterion("frame_image not like", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageIn(List<String> values) {
            addCriterion("frame_image in", values, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageNotIn(List<String> values) {
            addCriterion("frame_image not in", values, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageBetween(String value1, String value2) {
            addCriterion("frame_image between", value1, value2, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageNotBetween(String value1, String value2) {
            addCriterion("frame_image not between", value1, value2, "frameImage");
            return (Criteria) this;
        }

        public Criteria andUprightScoreIsNull() {
            addCriterion("upright_score is null");
            return (Criteria) this;
        }

        public Criteria andUprightScoreIsNotNull() {
            addCriterion("upright_score is not null");
            return (Criteria) this;
        }

        public Criteria andUprightScoreEqualTo(String value) {
            addCriterion("upright_score =", value, "uprightScore");
            return (Criteria) this;
        }

        public Criteria andUprightScoreNotEqualTo(String value) {
            addCriterion("upright_score <>", value, "uprightScore");
            return (Criteria) this;
        }

        public Criteria andUprightScoreGreaterThan(String value) {
            addCriterion("upright_score >", value, "uprightScore");
            return (Criteria) this;
        }

        public Criteria andUprightScoreGreaterThanOrEqualTo(String value) {
            addCriterion("upright_score >=", value, "uprightScore");
            return (Criteria) this;
        }

        public Criteria andUprightScoreLessThan(String value) {
            addCriterion("upright_score <", value, "uprightScore");
            return (Criteria) this;
        }

        public Criteria andUprightScoreLessThanOrEqualTo(String value) {
            addCriterion("upright_score <=", value, "uprightScore");
            return (Criteria) this;
        }

        public Criteria andUprightScoreLike(String value) {
            addCriterion("upright_score like", value, "uprightScore");
            return (Criteria) this;
        }

        public Criteria andUprightScoreNotLike(String value) {
            addCriterion("upright_score not like", value, "uprightScore");
            return (Criteria) this;
        }

        public Criteria andUprightScoreIn(List<String> values) {
            addCriterion("upright_score in", values, "uprightScore");
            return (Criteria) this;
        }

        public Criteria andUprightScoreNotIn(List<String> values) {
            addCriterion("upright_score not in", values, "uprightScore");
            return (Criteria) this;
        }

        public Criteria andUprightScoreBetween(String value1, String value2) {
            addCriterion("upright_score between", value1, value2, "uprightScore");
            return (Criteria) this;
        }

        public Criteria andUprightScoreNotBetween(String value1, String value2) {
            addCriterion("upright_score not between", value1, value2, "uprightScore");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreIsNull() {
            addCriterion("daylighting_score is null");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreIsNotNull() {
            addCriterion("daylighting_score is not null");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreEqualTo(String value) {
            addCriterion("daylighting_score =", value, "daylightingScore");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreNotEqualTo(String value) {
            addCriterion("daylighting_score <>", value, "daylightingScore");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreGreaterThan(String value) {
            addCriterion("daylighting_score >", value, "daylightingScore");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreGreaterThanOrEqualTo(String value) {
            addCriterion("daylighting_score >=", value, "daylightingScore");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreLessThan(String value) {
            addCriterion("daylighting_score <", value, "daylightingScore");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreLessThanOrEqualTo(String value) {
            addCriterion("daylighting_score <=", value, "daylightingScore");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreLike(String value) {
            addCriterion("daylighting_score like", value, "daylightingScore");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreNotLike(String value) {
            addCriterion("daylighting_score not like", value, "daylightingScore");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreIn(List<String> values) {
            addCriterion("daylighting_score in", values, "daylightingScore");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreNotIn(List<String> values) {
            addCriterion("daylighting_score not in", values, "daylightingScore");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreBetween(String value1, String value2) {
            addCriterion("daylighting_score between", value1, value2, "daylightingScore");
            return (Criteria) this;
        }

        public Criteria andDaylightingScoreNotBetween(String value1, String value2) {
            addCriterion("daylighting_score not between", value1, value2, "daylightingScore");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreIsNull() {
            addCriterion("distribution_score is null");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreIsNotNull() {
            addCriterion("distribution_score is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreEqualTo(String value) {
            addCriterion("distribution_score =", value, "distributionScore");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreNotEqualTo(String value) {
            addCriterion("distribution_score <>", value, "distributionScore");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreGreaterThan(String value) {
            addCriterion("distribution_score >", value, "distributionScore");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreGreaterThanOrEqualTo(String value) {
            addCriterion("distribution_score >=", value, "distributionScore");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreLessThan(String value) {
            addCriterion("distribution_score <", value, "distributionScore");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreLessThanOrEqualTo(String value) {
            addCriterion("distribution_score <=", value, "distributionScore");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreLike(String value) {
            addCriterion("distribution_score like", value, "distributionScore");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreNotLike(String value) {
            addCriterion("distribution_score not like", value, "distributionScore");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreIn(List<String> values) {
            addCriterion("distribution_score in", values, "distributionScore");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreNotIn(List<String> values) {
            addCriterion("distribution_score not in", values, "distributionScore");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreBetween(String value1, String value2) {
            addCriterion("distribution_score between", value1, value2, "distributionScore");
            return (Criteria) this;
        }

        public Criteria andDistributionScoreNotBetween(String value1, String value2) {
            addCriterion("distribution_score not between", value1, value2, "distributionScore");
            return (Criteria) this;
        }

        public Criteria andAreaScoreIsNull() {
            addCriterion("area_score is null");
            return (Criteria) this;
        }

        public Criteria andAreaScoreIsNotNull() {
            addCriterion("area_score is not null");
            return (Criteria) this;
        }

        public Criteria andAreaScoreEqualTo(String value) {
            addCriterion("area_score =", value, "areaScore");
            return (Criteria) this;
        }

        public Criteria andAreaScoreNotEqualTo(String value) {
            addCriterion("area_score <>", value, "areaScore");
            return (Criteria) this;
        }

        public Criteria andAreaScoreGreaterThan(String value) {
            addCriterion("area_score >", value, "areaScore");
            return (Criteria) this;
        }

        public Criteria andAreaScoreGreaterThanOrEqualTo(String value) {
            addCriterion("area_score >=", value, "areaScore");
            return (Criteria) this;
        }

        public Criteria andAreaScoreLessThan(String value) {
            addCriterion("area_score <", value, "areaScore");
            return (Criteria) this;
        }

        public Criteria andAreaScoreLessThanOrEqualTo(String value) {
            addCriterion("area_score <=", value, "areaScore");
            return (Criteria) this;
        }

        public Criteria andAreaScoreLike(String value) {
            addCriterion("area_score like", value, "areaScore");
            return (Criteria) this;
        }

        public Criteria andAreaScoreNotLike(String value) {
            addCriterion("area_score not like", value, "areaScore");
            return (Criteria) this;
        }

        public Criteria andAreaScoreIn(List<String> values) {
            addCriterion("area_score in", values, "areaScore");
            return (Criteria) this;
        }

        public Criteria andAreaScoreNotIn(List<String> values) {
            addCriterion("area_score not in", values, "areaScore");
            return (Criteria) this;
        }

        public Criteria andAreaScoreBetween(String value1, String value2) {
            addCriterion("area_score between", value1, value2, "areaScore");
            return (Criteria) this;
        }

        public Criteria andAreaScoreNotBetween(String value1, String value2) {
            addCriterion("area_score not between", value1, value2, "areaScore");
            return (Criteria) this;
        }

        public Criteria andEffienScoreIsNull() {
            addCriterion("effien_score is null");
            return (Criteria) this;
        }

        public Criteria andEffienScoreIsNotNull() {
            addCriterion("effien_score is not null");
            return (Criteria) this;
        }

        public Criteria andEffienScoreEqualTo(String value) {
            addCriterion("effien_score =", value, "effienScore");
            return (Criteria) this;
        }

        public Criteria andEffienScoreNotEqualTo(String value) {
            addCriterion("effien_score <>", value, "effienScore");
            return (Criteria) this;
        }

        public Criteria andEffienScoreGreaterThan(String value) {
            addCriterion("effien_score >", value, "effienScore");
            return (Criteria) this;
        }

        public Criteria andEffienScoreGreaterThanOrEqualTo(String value) {
            addCriterion("effien_score >=", value, "effienScore");
            return (Criteria) this;
        }

        public Criteria andEffienScoreLessThan(String value) {
            addCriterion("effien_score <", value, "effienScore");
            return (Criteria) this;
        }

        public Criteria andEffienScoreLessThanOrEqualTo(String value) {
            addCriterion("effien_score <=", value, "effienScore");
            return (Criteria) this;
        }

        public Criteria andEffienScoreLike(String value) {
            addCriterion("effien_score like", value, "effienScore");
            return (Criteria) this;
        }

        public Criteria andEffienScoreNotLike(String value) {
            addCriterion("effien_score not like", value, "effienScore");
            return (Criteria) this;
        }

        public Criteria andEffienScoreIn(List<String> values) {
            addCriterion("effien_score in", values, "effienScore");
            return (Criteria) this;
        }

        public Criteria andEffienScoreNotIn(List<String> values) {
            addCriterion("effien_score not in", values, "effienScore");
            return (Criteria) this;
        }

        public Criteria andEffienScoreBetween(String value1, String value2) {
            addCriterion("effien_score between", value1, value2, "effienScore");
            return (Criteria) this;
        }

        public Criteria andEffienScoreNotBetween(String value1, String value2) {
            addCriterion("effien_score not between", value1, value2, "effienScore");
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

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNull() {
            addCriterion("batch_id is null");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNotNull() {
            addCriterion("batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatchIdEqualTo(String value) {
            addCriterion("batch_id =", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotEqualTo(String value) {
            addCriterion("batch_id <>", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThan(String value) {
            addCriterion("batch_id >", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThanOrEqualTo(String value) {
            addCriterion("batch_id >=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThan(String value) {
            addCriterion("batch_id <", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThanOrEqualTo(String value) {
            addCriterion("batch_id <=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLike(String value) {
            addCriterion("batch_id like", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotLike(String value) {
            addCriterion("batch_id not like", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdIn(List<String> values) {
            addCriterion("batch_id in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotIn(List<String> values) {
            addCriterion("batch_id not in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdBetween(String value1, String value2) {
            addCriterion("batch_id between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotBetween(String value1, String value2) {
            addCriterion("batch_id not between", value1, value2, "batchId");
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