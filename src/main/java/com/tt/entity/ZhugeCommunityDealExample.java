package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZhugeCommunityDealExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZhugeCommunityDealExample() {
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

        public Criteria andDetailUrlIsNull() {
            addCriterion("detail_url is null");
            return (Criteria) this;
        }

        public Criteria andDetailUrlIsNotNull() {
            addCriterion("detail_url is not null");
            return (Criteria) this;
        }

        public Criteria andDetailUrlEqualTo(String value) {
            addCriterion("detail_url =", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlNotEqualTo(String value) {
            addCriterion("detail_url <>", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlGreaterThan(String value) {
            addCriterion("detail_url >", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlGreaterThanOrEqualTo(String value) {
            addCriterion("detail_url >=", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlLessThan(String value) {
            addCriterion("detail_url <", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlLessThanOrEqualTo(String value) {
            addCriterion("detail_url <=", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlLike(String value) {
            addCriterion("detail_url like", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlNotLike(String value) {
            addCriterion("detail_url not like", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlIn(List<String> values) {
            addCriterion("detail_url in", values, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlNotIn(List<String> values) {
            addCriterion("detail_url not in", values, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlBetween(String value1, String value2) {
            addCriterion("detail_url between", value1, value2, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlNotBetween(String value1, String value2) {
            addCriterion("detail_url not between", value1, value2, "detailUrl");
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

        public Criteria andDealTotalPriceIsNull() {
            addCriterion("deal_total_price is null");
            return (Criteria) this;
        }

        public Criteria andDealTotalPriceIsNotNull() {
            addCriterion("deal_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andDealTotalPriceEqualTo(String value) {
            addCriterion("deal_total_price =", value, "dealTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDealTotalPriceNotEqualTo(String value) {
            addCriterion("deal_total_price <>", value, "dealTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDealTotalPriceGreaterThan(String value) {
            addCriterion("deal_total_price >", value, "dealTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDealTotalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("deal_total_price >=", value, "dealTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDealTotalPriceLessThan(String value) {
            addCriterion("deal_total_price <", value, "dealTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDealTotalPriceLessThanOrEqualTo(String value) {
            addCriterion("deal_total_price <=", value, "dealTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDealTotalPriceLike(String value) {
            addCriterion("deal_total_price like", value, "dealTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDealTotalPriceNotLike(String value) {
            addCriterion("deal_total_price not like", value, "dealTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDealTotalPriceIn(List<String> values) {
            addCriterion("deal_total_price in", values, "dealTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDealTotalPriceNotIn(List<String> values) {
            addCriterion("deal_total_price not in", values, "dealTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDealTotalPriceBetween(String value1, String value2) {
            addCriterion("deal_total_price between", value1, value2, "dealTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDealTotalPriceNotBetween(String value1, String value2) {
            addCriterion("deal_total_price not between", value1, value2, "dealTotalPrice");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceIsNull() {
            addCriterion("deal_average_price is null");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceIsNotNull() {
            addCriterion("deal_average_price is not null");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceEqualTo(String value) {
            addCriterion("deal_average_price =", value, "dealAveragePrice");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceNotEqualTo(String value) {
            addCriterion("deal_average_price <>", value, "dealAveragePrice");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceGreaterThan(String value) {
            addCriterion("deal_average_price >", value, "dealAveragePrice");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceGreaterThanOrEqualTo(String value) {
            addCriterion("deal_average_price >=", value, "dealAveragePrice");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceLessThan(String value) {
            addCriterion("deal_average_price <", value, "dealAveragePrice");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceLessThanOrEqualTo(String value) {
            addCriterion("deal_average_price <=", value, "dealAveragePrice");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceLike(String value) {
            addCriterion("deal_average_price like", value, "dealAveragePrice");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceNotLike(String value) {
            addCriterion("deal_average_price not like", value, "dealAveragePrice");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceIn(List<String> values) {
            addCriterion("deal_average_price in", values, "dealAveragePrice");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceNotIn(List<String> values) {
            addCriterion("deal_average_price not in", values, "dealAveragePrice");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceBetween(String value1, String value2) {
            addCriterion("deal_average_price between", value1, value2, "dealAveragePrice");
            return (Criteria) this;
        }

        public Criteria andDealAveragePriceNotBetween(String value1, String value2) {
            addCriterion("deal_average_price not between", value1, value2, "dealAveragePrice");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andLayoutIsNull() {
            addCriterion("layout is null");
            return (Criteria) this;
        }

        public Criteria andLayoutIsNotNull() {
            addCriterion("layout is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutEqualTo(String value) {
            addCriterion("layout =", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotEqualTo(String value) {
            addCriterion("layout <>", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutGreaterThan(String value) {
            addCriterion("layout >", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutGreaterThanOrEqualTo(String value) {
            addCriterion("layout >=", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutLessThan(String value) {
            addCriterion("layout <", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutLessThanOrEqualTo(String value) {
            addCriterion("layout <=", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutLike(String value) {
            addCriterion("layout like", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotLike(String value) {
            addCriterion("layout not like", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutIn(List<String> values) {
            addCriterion("layout in", values, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotIn(List<String> values) {
            addCriterion("layout not in", values, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutBetween(String value1, String value2) {
            addCriterion("layout between", value1, value2, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotBetween(String value1, String value2) {
            addCriterion("layout not between", value1, value2, "layout");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(String value) {
            addCriterion("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(String value) {
            addCriterion("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(String value) {
            addCriterion("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(String value) {
            addCriterion("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(String value) {
            addCriterion("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(String value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLike(String value) {
            addCriterion("deal_time like", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotLike(String value) {
            addCriterion("deal_time not like", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<String> values) {
            addCriterion("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<String> values) {
            addCriterion("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(String value1, String value2) {
            addCriterion("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(String value1, String value2) {
            addCriterion("deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealSrcIsNull() {
            addCriterion("deal_src is null");
            return (Criteria) this;
        }

        public Criteria andDealSrcIsNotNull() {
            addCriterion("deal_src is not null");
            return (Criteria) this;
        }

        public Criteria andDealSrcEqualTo(String value) {
            addCriterion("deal_src =", value, "dealSrc");
            return (Criteria) this;
        }

        public Criteria andDealSrcNotEqualTo(String value) {
            addCriterion("deal_src <>", value, "dealSrc");
            return (Criteria) this;
        }

        public Criteria andDealSrcGreaterThan(String value) {
            addCriterion("deal_src >", value, "dealSrc");
            return (Criteria) this;
        }

        public Criteria andDealSrcGreaterThanOrEqualTo(String value) {
            addCriterion("deal_src >=", value, "dealSrc");
            return (Criteria) this;
        }

        public Criteria andDealSrcLessThan(String value) {
            addCriterion("deal_src <", value, "dealSrc");
            return (Criteria) this;
        }

        public Criteria andDealSrcLessThanOrEqualTo(String value) {
            addCriterion("deal_src <=", value, "dealSrc");
            return (Criteria) this;
        }

        public Criteria andDealSrcLike(String value) {
            addCriterion("deal_src like", value, "dealSrc");
            return (Criteria) this;
        }

        public Criteria andDealSrcNotLike(String value) {
            addCriterion("deal_src not like", value, "dealSrc");
            return (Criteria) this;
        }

        public Criteria andDealSrcIn(List<String> values) {
            addCriterion("deal_src in", values, "dealSrc");
            return (Criteria) this;
        }

        public Criteria andDealSrcNotIn(List<String> values) {
            addCriterion("deal_src not in", values, "dealSrc");
            return (Criteria) this;
        }

        public Criteria andDealSrcBetween(String value1, String value2) {
            addCriterion("deal_src between", value1, value2, "dealSrc");
            return (Criteria) this;
        }

        public Criteria andDealSrcNotBetween(String value1, String value2) {
            addCriterion("deal_src not between", value1, value2, "dealSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcIsNull() {
            addCriterion("data_src is null");
            return (Criteria) this;
        }

        public Criteria andDataSrcIsNotNull() {
            addCriterion("data_src is not null");
            return (Criteria) this;
        }

        public Criteria andDataSrcEqualTo(String value) {
            addCriterion("data_src =", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcNotEqualTo(String value) {
            addCriterion("data_src <>", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcGreaterThan(String value) {
            addCriterion("data_src >", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcGreaterThanOrEqualTo(String value) {
            addCriterion("data_src >=", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcLessThan(String value) {
            addCriterion("data_src <", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcLessThanOrEqualTo(String value) {
            addCriterion("data_src <=", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcLike(String value) {
            addCriterion("data_src like", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcNotLike(String value) {
            addCriterion("data_src not like", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcIn(List<String> values) {
            addCriterion("data_src in", values, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcNotIn(List<String> values) {
            addCriterion("data_src not in", values, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcBetween(String value1, String value2) {
            addCriterion("data_src between", value1, value2, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcNotBetween(String value1, String value2) {
            addCriterion("data_src not between", value1, value2, "dataSrc");
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