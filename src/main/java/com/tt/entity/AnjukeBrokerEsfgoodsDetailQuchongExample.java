package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnjukeBrokerEsfgoodsDetailQuchongExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnjukeBrokerEsfgoodsDetailQuchongExample() {
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
        public Criteria andPicUrlIsNull() {
            addCriterion("pic_url is null");
            return (Criteria) this;
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

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlIsNull() {
            addCriterion("broker_url is null");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlIsNotNull() {
            addCriterion("broker_url is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlEqualTo(String value) {
            addCriterion("broker_url =", value, "brokerUrl");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlNotEqualTo(String value) {
            addCriterion("broker_url <>", value, "brokerUrl");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlGreaterThan(String value) {
            addCriterion("broker_url >", value, "brokerUrl");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlGreaterThanOrEqualTo(String value) {
            addCriterion("broker_url >=", value, "brokerUrl");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlLessThan(String value) {
            addCriterion("broker_url <", value, "brokerUrl");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlLessThanOrEqualTo(String value) {
            addCriterion("broker_url <=", value, "brokerUrl");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlLike(String value) {
            addCriterion("broker_url like", value, "brokerUrl");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlNotLike(String value) {
            addCriterion("broker_url not like", value, "brokerUrl");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlIn(List<String> values) {
            addCriterion("broker_url in", values, "brokerUrl");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlNotIn(List<String> values) {
            addCriterion("broker_url not in", values, "brokerUrl");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlBetween(String value1, String value2) {
            addCriterion("broker_url between", value1, value2, "brokerUrl");
            return (Criteria) this;
        }

        public Criteria andBrokerUrlNotBetween(String value1, String value2) {
            addCriterion("broker_url not between", value1, value2, "brokerUrl");
            return (Criteria) this;
        }

        public Criteria andBrokerIdIsNull() {
            addCriterion("broker_id is null");
            return (Criteria) this;
        }

        public Criteria andBrokerIdIsNotNull() {
            addCriterion("broker_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerIdEqualTo(String value) {
            addCriterion("broker_id =", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotEqualTo(String value) {
            addCriterion("broker_id <>", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdGreaterThan(String value) {
            addCriterion("broker_id >", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdGreaterThanOrEqualTo(String value) {
            addCriterion("broker_id >=", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdLessThan(String value) {
            addCriterion("broker_id <", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdLessThanOrEqualTo(String value) {
            addCriterion("broker_id <=", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdLike(String value) {
            addCriterion("broker_id like", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotLike(String value) {
            addCriterion("broker_id not like", value, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdIn(List<String> values) {
            addCriterion("broker_id in", values, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotIn(List<String> values) {
            addCriterion("broker_id not in", values, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdBetween(String value1, String value2) {
            addCriterion("broker_id between", value1, value2, "brokerId");
            return (Criteria) this;
        }

        public Criteria andBrokerIdNotBetween(String value1, String value2) {
            addCriterion("broker_id not between", value1, value2, "brokerId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeIsNull() {
            addCriterion("goods_pubtime is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeIsNotNull() {
            addCriterion("goods_pubtime is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeEqualTo(String value) {
            addCriterion("goods_pubtime =", value, "goodsPubtime");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeNotEqualTo(String value) {
            addCriterion("goods_pubtime <>", value, "goodsPubtime");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeGreaterThan(String value) {
            addCriterion("goods_pubtime >", value, "goodsPubtime");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_pubtime >=", value, "goodsPubtime");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeLessThan(String value) {
            addCriterion("goods_pubtime <", value, "goodsPubtime");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeLessThanOrEqualTo(String value) {
            addCriterion("goods_pubtime <=", value, "goodsPubtime");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeLike(String value) {
            addCriterion("goods_pubtime like", value, "goodsPubtime");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeNotLike(String value) {
            addCriterion("goods_pubtime not like", value, "goodsPubtime");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeIn(List<String> values) {
            addCriterion("goods_pubtime in", values, "goodsPubtime");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeNotIn(List<String> values) {
            addCriterion("goods_pubtime not in", values, "goodsPubtime");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeBetween(String value1, String value2) {
            addCriterion("goods_pubtime between", value1, value2, "goodsPubtime");
            return (Criteria) this;
        }

        public Criteria andGoodsPubtimeNotBetween(String value1, String value2) {
            addCriterion("goods_pubtime not between", value1, value2, "goodsPubtime");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotIsNull() {
            addCriterion("surface_plot is null");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotIsNotNull() {
            addCriterion("surface_plot is not null");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotEqualTo(String value) {
            addCriterion("surface_plot =", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotNotEqualTo(String value) {
            addCriterion("surface_plot <>", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotGreaterThan(String value) {
            addCriterion("surface_plot >", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotGreaterThanOrEqualTo(String value) {
            addCriterion("surface_plot >=", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotLessThan(String value) {
            addCriterion("surface_plot <", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotLessThanOrEqualTo(String value) {
            addCriterion("surface_plot <=", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotLike(String value) {
            addCriterion("surface_plot like", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotNotLike(String value) {
            addCriterion("surface_plot not like", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotIn(List<String> values) {
            addCriterion("surface_plot in", values, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotNotIn(List<String> values) {
            addCriterion("surface_plot not in", values, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotBetween(String value1, String value2) {
            addCriterion("surface_plot between", value1, value2, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotNotBetween(String value1, String value2) {
            addCriterion("surface_plot not between", value1, value2, "surfacePlot");
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

        public Criteria andTitleUrlIsNull() {
            addCriterion("title_url is null");
            return (Criteria) this;
        }

        public Criteria andTitleUrlIsNotNull() {
            addCriterion("title_url is not null");
            return (Criteria) this;
        }

        public Criteria andTitleUrlEqualTo(String value) {
            addCriterion("title_url =", value, "titleUrl");
            return (Criteria) this;
        }

        public Criteria andTitleUrlNotEqualTo(String value) {
            addCriterion("title_url <>", value, "titleUrl");
            return (Criteria) this;
        }

        public Criteria andTitleUrlGreaterThan(String value) {
            addCriterion("title_url >", value, "titleUrl");
            return (Criteria) this;
        }

        public Criteria andTitleUrlGreaterThanOrEqualTo(String value) {
            addCriterion("title_url >=", value, "titleUrl");
            return (Criteria) this;
        }

        public Criteria andTitleUrlLessThan(String value) {
            addCriterion("title_url <", value, "titleUrl");
            return (Criteria) this;
        }

        public Criteria andTitleUrlLessThanOrEqualTo(String value) {
            addCriterion("title_url <=", value, "titleUrl");
            return (Criteria) this;
        }

        public Criteria andTitleUrlLike(String value) {
            addCriterion("title_url like", value, "titleUrl");
            return (Criteria) this;
        }

        public Criteria andTitleUrlNotLike(String value) {
            addCriterion("title_url not like", value, "titleUrl");
            return (Criteria) this;
        }

        public Criteria andTitleUrlIn(List<String> values) {
            addCriterion("title_url in", values, "titleUrl");
            return (Criteria) this;
        }

        public Criteria andTitleUrlNotIn(List<String> values) {
            addCriterion("title_url not in", values, "titleUrl");
            return (Criteria) this;
        }

        public Criteria andTitleUrlBetween(String value1, String value2) {
            addCriterion("title_url between", value1, value2, "titleUrl");
            return (Criteria) this;
        }

        public Criteria andTitleUrlNotBetween(String value1, String value2) {
            addCriterion("title_url not between", value1, value2, "titleUrl");
            return (Criteria) this;
        }

        public Criteria andTitleAreaIsNull() {
            addCriterion("title_area is null");
            return (Criteria) this;
        }

        public Criteria andTitleAreaIsNotNull() {
            addCriterion("title_area is not null");
            return (Criteria) this;
        }

        public Criteria andTitleAreaEqualTo(String value) {
            addCriterion("title_area =", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaNotEqualTo(String value) {
            addCriterion("title_area <>", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaGreaterThan(String value) {
            addCriterion("title_area >", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaGreaterThanOrEqualTo(String value) {
            addCriterion("title_area >=", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaLessThan(String value) {
            addCriterion("title_area <", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaLessThanOrEqualTo(String value) {
            addCriterion("title_area <=", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaLike(String value) {
            addCriterion("title_area like", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaNotLike(String value) {
            addCriterion("title_area not like", value, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaIn(List<String> values) {
            addCriterion("title_area in", values, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaNotIn(List<String> values) {
            addCriterion("title_area not in", values, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaBetween(String value1, String value2) {
            addCriterion("title_area between", value1, value2, "titleArea");
            return (Criteria) this;
        }

        public Criteria andTitleAreaNotBetween(String value1, String value2) {
            addCriterion("title_area not between", value1, value2, "titleArea");
            return (Criteria) this;
        }

        public Criteria andHomeTotalIsNull() {
            addCriterion("home_total is null");
            return (Criteria) this;
        }

        public Criteria andHomeTotalIsNotNull() {
            addCriterion("home_total is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTotalEqualTo(String value) {
            addCriterion("home_total =", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalNotEqualTo(String value) {
            addCriterion("home_total <>", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalGreaterThan(String value) {
            addCriterion("home_total >", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalGreaterThanOrEqualTo(String value) {
            addCriterion("home_total >=", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalLessThan(String value) {
            addCriterion("home_total <", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalLessThanOrEqualTo(String value) {
            addCriterion("home_total <=", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalLike(String value) {
            addCriterion("home_total like", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalNotLike(String value) {
            addCriterion("home_total not like", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalIn(List<String> values) {
            addCriterion("home_total in", values, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalNotIn(List<String> values) {
            addCriterion("home_total not in", values, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalBetween(String value1, String value2) {
            addCriterion("home_total between", value1, value2, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalNotBetween(String value1, String value2) {
            addCriterion("home_total not between", value1, value2, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andPlotRateIsNull() {
            addCriterion("plot_rate is null");
            return (Criteria) this;
        }

        public Criteria andPlotRateIsNotNull() {
            addCriterion("plot_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPlotRateEqualTo(String value) {
            addCriterion("plot_rate =", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateNotEqualTo(String value) {
            addCriterion("plot_rate <>", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateGreaterThan(String value) {
            addCriterion("plot_rate >", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateGreaterThanOrEqualTo(String value) {
            addCriterion("plot_rate >=", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateLessThan(String value) {
            addCriterion("plot_rate <", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateLessThanOrEqualTo(String value) {
            addCriterion("plot_rate <=", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateLike(String value) {
            addCriterion("plot_rate like", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateNotLike(String value) {
            addCriterion("plot_rate not like", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateIn(List<String> values) {
            addCriterion("plot_rate in", values, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateNotIn(List<String> values) {
            addCriterion("plot_rate not in", values, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateBetween(String value1, String value2) {
            addCriterion("plot_rate between", value1, value2, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateNotBetween(String value1, String value2) {
            addCriterion("plot_rate not between", value1, value2, "plotRate");
            return (Criteria) this;
        }

        public Criteria andParkNumIsNull() {
            addCriterion("park_num is null");
            return (Criteria) this;
        }

        public Criteria andParkNumIsNotNull() {
            addCriterion("park_num is not null");
            return (Criteria) this;
        }

        public Criteria andParkNumEqualTo(String value) {
            addCriterion("park_num =", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumNotEqualTo(String value) {
            addCriterion("park_num <>", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumGreaterThan(String value) {
            addCriterion("park_num >", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumGreaterThanOrEqualTo(String value) {
            addCriterion("park_num >=", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumLessThan(String value) {
            addCriterion("park_num <", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumLessThanOrEqualTo(String value) {
            addCriterion("park_num <=", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumLike(String value) {
            addCriterion("park_num like", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumNotLike(String value) {
            addCriterion("park_num not like", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumIn(List<String> values) {
            addCriterion("park_num in", values, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumNotIn(List<String> values) {
            addCriterion("park_num not in", values, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumBetween(String value1, String value2) {
            addCriterion("park_num between", value1, value2, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumNotBetween(String value1, String value2) {
            addCriterion("park_num not between", value1, value2, "parkNum");
            return (Criteria) this;
        }

        public Criteria andGreenRateIsNull() {
            addCriterion("green_rate is null");
            return (Criteria) this;
        }

        public Criteria andGreenRateIsNotNull() {
            addCriterion("green_rate is not null");
            return (Criteria) this;
        }

        public Criteria andGreenRateEqualTo(String value) {
            addCriterion("green_rate =", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateNotEqualTo(String value) {
            addCriterion("green_rate <>", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateGreaterThan(String value) {
            addCriterion("green_rate >", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateGreaterThanOrEqualTo(String value) {
            addCriterion("green_rate >=", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateLessThan(String value) {
            addCriterion("green_rate <", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateLessThanOrEqualTo(String value) {
            addCriterion("green_rate <=", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateLike(String value) {
            addCriterion("green_rate like", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateNotLike(String value) {
            addCriterion("green_rate not like", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateIn(List<String> values) {
            addCriterion("green_rate in", values, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateNotIn(List<String> values) {
            addCriterion("green_rate not in", values, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateBetween(String value1, String value2) {
            addCriterion("green_rate between", value1, value2, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateNotBetween(String value1, String value2) {
            addCriterion("green_rate not between", value1, value2, "greenRate");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceIsNull() {
            addCriterion("property_price is null");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceIsNotNull() {
            addCriterion("property_price is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceEqualTo(String value) {
            addCriterion("property_price =", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotEqualTo(String value) {
            addCriterion("property_price <>", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceGreaterThan(String value) {
            addCriterion("property_price >", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceGreaterThanOrEqualTo(String value) {
            addCriterion("property_price >=", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceLessThan(String value) {
            addCriterion("property_price <", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceLessThanOrEqualTo(String value) {
            addCriterion("property_price <=", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceLike(String value) {
            addCriterion("property_price like", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotLike(String value) {
            addCriterion("property_price not like", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceIn(List<String> values) {
            addCriterion("property_price in", values, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotIn(List<String> values) {
            addCriterion("property_price not in", values, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceBetween(String value1, String value2) {
            addCriterion("property_price between", value1, value2, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotBetween(String value1, String value2) {
            addCriterion("property_price not between", value1, value2, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andPlateIsNull() {
            addCriterion("plate is null");
            return (Criteria) this;
        }

        public Criteria andPlateIsNotNull() {
            addCriterion("plate is not null");
            return (Criteria) this;
        }

        public Criteria andPlateEqualTo(String value) {
            addCriterion("plate =", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateNotEqualTo(String value) {
            addCriterion("plate <>", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateGreaterThan(String value) {
            addCriterion("plate >", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateGreaterThanOrEqualTo(String value) {
            addCriterion("plate >=", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateLessThan(String value) {
            addCriterion("plate <", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateLessThanOrEqualTo(String value) {
            addCriterion("plate <=", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateLike(String value) {
            addCriterion("plate like", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateNotLike(String value) {
            addCriterion("plate not like", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateIn(List<String> values) {
            addCriterion("plate in", values, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateNotIn(List<String> values) {
            addCriterion("plate not in", values, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateBetween(String value1, String value2) {
            addCriterion("plate between", value1, value2, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateNotBetween(String value1, String value2) {
            addCriterion("plate not between", value1, value2, "plate");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andBuildYearIsNull() {
            addCriterion("build_year is null");
            return (Criteria) this;
        }

        public Criteria andBuildYearIsNotNull() {
            addCriterion("build_year is not null");
            return (Criteria) this;
        }

        public Criteria andBuildYearEqualTo(String value) {
            addCriterion("build_year =", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotEqualTo(String value) {
            addCriterion("build_year <>", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearGreaterThan(String value) {
            addCriterion("build_year >", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearGreaterThanOrEqualTo(String value) {
            addCriterion("build_year >=", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearLessThan(String value) {
            addCriterion("build_year <", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearLessThanOrEqualTo(String value) {
            addCriterion("build_year <=", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearLike(String value) {
            addCriterion("build_year like", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotLike(String value) {
            addCriterion("build_year not like", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearIn(List<String> values) {
            addCriterion("build_year in", values, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotIn(List<String> values) {
            addCriterion("build_year not in", values, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearBetween(String value1, String value2) {
            addCriterion("build_year between", value1, value2, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotBetween(String value1, String value2) {
            addCriterion("build_year not between", value1, value2, "buildYear");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIsNull() {
            addCriterion("property_type is null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIsNotNull() {
            addCriterion("property_type is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeEqualTo(String value) {
            addCriterion("property_type =", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotEqualTo(String value) {
            addCriterion("property_type <>", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThan(String value) {
            addCriterion("property_type >", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("property_type >=", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThan(String value) {
            addCriterion("property_type <", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThanOrEqualTo(String value) {
            addCriterion("property_type <=", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLike(String value) {
            addCriterion("property_type like", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotLike(String value) {
            addCriterion("property_type not like", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIn(List<String> values) {
            addCriterion("property_type in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotIn(List<String> values) {
            addCriterion("property_type not in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeBetween(String value1, String value2) {
            addCriterion("property_type between", value1, value2, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotBetween(String value1, String value2) {
            addCriterion("property_type not between", value1, value2, "propertyType");
            return (Criteria) this;
        }

        public Criteria andHousingYearsIsNull() {
            addCriterion("housing_years is null");
            return (Criteria) this;
        }

        public Criteria andHousingYearsIsNotNull() {
            addCriterion("housing_years is not null");
            return (Criteria) this;
        }

        public Criteria andHousingYearsEqualTo(String value) {
            addCriterion("housing_years =", value, "housingYears");
            return (Criteria) this;
        }

        public Criteria andHousingYearsNotEqualTo(String value) {
            addCriterion("housing_years <>", value, "housingYears");
            return (Criteria) this;
        }

        public Criteria andHousingYearsGreaterThan(String value) {
            addCriterion("housing_years >", value, "housingYears");
            return (Criteria) this;
        }

        public Criteria andHousingYearsGreaterThanOrEqualTo(String value) {
            addCriterion("housing_years >=", value, "housingYears");
            return (Criteria) this;
        }

        public Criteria andHousingYearsLessThan(String value) {
            addCriterion("housing_years <", value, "housingYears");
            return (Criteria) this;
        }

        public Criteria andHousingYearsLessThanOrEqualTo(String value) {
            addCriterion("housing_years <=", value, "housingYears");
            return (Criteria) this;
        }

        public Criteria andHousingYearsLike(String value) {
            addCriterion("housing_years like", value, "housingYears");
            return (Criteria) this;
        }

        public Criteria andHousingYearsNotLike(String value) {
            addCriterion("housing_years not like", value, "housingYears");
            return (Criteria) this;
        }

        public Criteria andHousingYearsIn(List<String> values) {
            addCriterion("housing_years in", values, "housingYears");
            return (Criteria) this;
        }

        public Criteria andHousingYearsNotIn(List<String> values) {
            addCriterion("housing_years not in", values, "housingYears");
            return (Criteria) this;
        }

        public Criteria andHousingYearsBetween(String value1, String value2) {
            addCriterion("housing_years between", value1, value2, "housingYears");
            return (Criteria) this;
        }

        public Criteria andHousingYearsNotBetween(String value1, String value2) {
            addCriterion("housing_years not between", value1, value2, "housingYears");
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

        public Criteria andOrientationsIsNull() {
            addCriterion("orientations is null");
            return (Criteria) this;
        }

        public Criteria andOrientationsIsNotNull() {
            addCriterion("orientations is not null");
            return (Criteria) this;
        }

        public Criteria andOrientationsEqualTo(String value) {
            addCriterion("orientations =", value, "orientations");
            return (Criteria) this;
        }

        public Criteria andOrientationsNotEqualTo(String value) {
            addCriterion("orientations <>", value, "orientations");
            return (Criteria) this;
        }

        public Criteria andOrientationsGreaterThan(String value) {
            addCriterion("orientations >", value, "orientations");
            return (Criteria) this;
        }

        public Criteria andOrientationsGreaterThanOrEqualTo(String value) {
            addCriterion("orientations >=", value, "orientations");
            return (Criteria) this;
        }

        public Criteria andOrientationsLessThan(String value) {
            addCriterion("orientations <", value, "orientations");
            return (Criteria) this;
        }

        public Criteria andOrientationsLessThanOrEqualTo(String value) {
            addCriterion("orientations <=", value, "orientations");
            return (Criteria) this;
        }

        public Criteria andOrientationsLike(String value) {
            addCriterion("orientations like", value, "orientations");
            return (Criteria) this;
        }

        public Criteria andOrientationsNotLike(String value) {
            addCriterion("orientations not like", value, "orientations");
            return (Criteria) this;
        }

        public Criteria andOrientationsIn(List<String> values) {
            addCriterion("orientations in", values, "orientations");
            return (Criteria) this;
        }

        public Criteria andOrientationsNotIn(List<String> values) {
            addCriterion("orientations not in", values, "orientations");
            return (Criteria) this;
        }

        public Criteria andOrientationsBetween(String value1, String value2) {
            addCriterion("orientations between", value1, value2, "orientations");
            return (Criteria) this;
        }

        public Criteria andOrientationsNotBetween(String value1, String value2) {
            addCriterion("orientations not between", value1, value2, "orientations");
            return (Criteria) this;
        }

        public Criteria andFloorHeightIsNull() {
            addCriterion("floor_height is null");
            return (Criteria) this;
        }

        public Criteria andFloorHeightIsNotNull() {
            addCriterion("floor_height is not null");
            return (Criteria) this;
        }

        public Criteria andFloorHeightEqualTo(String value) {
            addCriterion("floor_height =", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightNotEqualTo(String value) {
            addCriterion("floor_height <>", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightGreaterThan(String value) {
            addCriterion("floor_height >", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightGreaterThanOrEqualTo(String value) {
            addCriterion("floor_height >=", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightLessThan(String value) {
            addCriterion("floor_height <", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightLessThanOrEqualTo(String value) {
            addCriterion("floor_height <=", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightLike(String value) {
            addCriterion("floor_height like", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightNotLike(String value) {
            addCriterion("floor_height not like", value, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightIn(List<String> values) {
            addCriterion("floor_height in", values, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightNotIn(List<String> values) {
            addCriterion("floor_height not in", values, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightBetween(String value1, String value2) {
            addCriterion("floor_height between", value1, value2, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andFloorHeightNotBetween(String value1, String value2) {
            addCriterion("floor_height not between", value1, value2, "floorHeight");
            return (Criteria) this;
        }

        public Criteria andSoleHousingIsNull() {
            addCriterion("sole_housing is null");
            return (Criteria) this;
        }

        public Criteria andSoleHousingIsNotNull() {
            addCriterion("sole_housing is not null");
            return (Criteria) this;
        }

        public Criteria andSoleHousingEqualTo(String value) {
            addCriterion("sole_housing =", value, "soleHousing");
            return (Criteria) this;
        }

        public Criteria andSoleHousingNotEqualTo(String value) {
            addCriterion("sole_housing <>", value, "soleHousing");
            return (Criteria) this;
        }

        public Criteria andSoleHousingGreaterThan(String value) {
            addCriterion("sole_housing >", value, "soleHousing");
            return (Criteria) this;
        }

        public Criteria andSoleHousingGreaterThanOrEqualTo(String value) {
            addCriterion("sole_housing >=", value, "soleHousing");
            return (Criteria) this;
        }

        public Criteria andSoleHousingLessThan(String value) {
            addCriterion("sole_housing <", value, "soleHousing");
            return (Criteria) this;
        }

        public Criteria andSoleHousingLessThanOrEqualTo(String value) {
            addCriterion("sole_housing <=", value, "soleHousing");
            return (Criteria) this;
        }

        public Criteria andSoleHousingLike(String value) {
            addCriterion("sole_housing like", value, "soleHousing");
            return (Criteria) this;
        }

        public Criteria andSoleHousingNotLike(String value) {
            addCriterion("sole_housing not like", value, "soleHousing");
            return (Criteria) this;
        }

        public Criteria andSoleHousingIn(List<String> values) {
            addCriterion("sole_housing in", values, "soleHousing");
            return (Criteria) this;
        }

        public Criteria andSoleHousingNotIn(List<String> values) {
            addCriterion("sole_housing not in", values, "soleHousing");
            return (Criteria) this;
        }

        public Criteria andSoleHousingBetween(String value1, String value2) {
            addCriterion("sole_housing between", value1, value2, "soleHousing");
            return (Criteria) this;
        }

        public Criteria andSoleHousingNotBetween(String value1, String value2) {
            addCriterion("sole_housing not between", value1, value2, "soleHousing");
            return (Criteria) this;
        }

        public Criteria andAvgPriceIsNull() {
            addCriterion("avg_price is null");
            return (Criteria) this;
        }

        public Criteria andAvgPriceIsNotNull() {
            addCriterion("avg_price is not null");
            return (Criteria) this;
        }

        public Criteria andAvgPriceEqualTo(String value) {
            addCriterion("avg_price =", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceNotEqualTo(String value) {
            addCriterion("avg_price <>", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceGreaterThan(String value) {
            addCriterion("avg_price >", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceGreaterThanOrEqualTo(String value) {
            addCriterion("avg_price >=", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceLessThan(String value) {
            addCriterion("avg_price <", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceLessThanOrEqualTo(String value) {
            addCriterion("avg_price <=", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceLike(String value) {
            addCriterion("avg_price like", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceNotLike(String value) {
            addCriterion("avg_price not like", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceIn(List<String> values) {
            addCriterion("avg_price in", values, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceNotIn(List<String> values) {
            addCriterion("avg_price not in", values, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceBetween(String value1, String value2) {
            addCriterion("avg_price between", value1, value2, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceNotBetween(String value1, String value2) {
            addCriterion("avg_price not between", value1, value2, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(String value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(String value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(String value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(String value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(String value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLike(String value) {
            addCriterion("total_price like", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotLike(String value) {
            addCriterion("total_price not like", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<String> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<String> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(String value1, String value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(String value1, String value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andDownPaymentIsNull() {
            addCriterion("down_payment is null");
            return (Criteria) this;
        }

        public Criteria andDownPaymentIsNotNull() {
            addCriterion("down_payment is not null");
            return (Criteria) this;
        }

        public Criteria andDownPaymentEqualTo(String value) {
            addCriterion("down_payment =", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentNotEqualTo(String value) {
            addCriterion("down_payment <>", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentGreaterThan(String value) {
            addCriterion("down_payment >", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("down_payment >=", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentLessThan(String value) {
            addCriterion("down_payment <", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentLessThanOrEqualTo(String value) {
            addCriterion("down_payment <=", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentLike(String value) {
            addCriterion("down_payment like", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentNotLike(String value) {
            addCriterion("down_payment not like", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentIn(List<String> values) {
            addCriterion("down_payment in", values, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentNotIn(List<String> values) {
            addCriterion("down_payment not in", values, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentBetween(String value1, String value2) {
            addCriterion("down_payment between", value1, value2, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentNotBetween(String value1, String value2) {
            addCriterion("down_payment not between", value1, value2, "downPayment");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentIsNull() {
            addCriterion("monthly_payment is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentIsNotNull() {
            addCriterion("monthly_payment is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentEqualTo(String value) {
            addCriterion("monthly_payment =", value, "monthlyPayment");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentNotEqualTo(String value) {
            addCriterion("monthly_payment <>", value, "monthlyPayment");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentGreaterThan(String value) {
            addCriterion("monthly_payment >", value, "monthlyPayment");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("monthly_payment >=", value, "monthlyPayment");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentLessThan(String value) {
            addCriterion("monthly_payment <", value, "monthlyPayment");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentLessThanOrEqualTo(String value) {
            addCriterion("monthly_payment <=", value, "monthlyPayment");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentLike(String value) {
            addCriterion("monthly_payment like", value, "monthlyPayment");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentNotLike(String value) {
            addCriterion("monthly_payment not like", value, "monthlyPayment");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentIn(List<String> values) {
            addCriterion("monthly_payment in", values, "monthlyPayment");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentNotIn(List<String> values) {
            addCriterion("monthly_payment not in", values, "monthlyPayment");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentBetween(String value1, String value2) {
            addCriterion("monthly_payment between", value1, value2, "monthlyPayment");
            return (Criteria) this;
        }

        public Criteria andMonthlyPaymentNotBetween(String value1, String value2) {
            addCriterion("monthly_payment not between", value1, value2, "monthlyPayment");
            return (Criteria) this;
        }

        public Criteria andDecorationIsNull() {
            addCriterion("decoration is null");
            return (Criteria) this;
        }

        public Criteria andDecorationIsNotNull() {
            addCriterion("decoration is not null");
            return (Criteria) this;
        }

        public Criteria andDecorationEqualTo(String value) {
            addCriterion("decoration =", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotEqualTo(String value) {
            addCriterion("decoration <>", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationGreaterThan(String value) {
            addCriterion("decoration >", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationGreaterThanOrEqualTo(String value) {
            addCriterion("decoration >=", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationLessThan(String value) {
            addCriterion("decoration <", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationLessThanOrEqualTo(String value) {
            addCriterion("decoration <=", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationLike(String value) {
            addCriterion("decoration like", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotLike(String value) {
            addCriterion("decoration not like", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationIn(List<String> values) {
            addCriterion("decoration in", values, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotIn(List<String> values) {
            addCriterion("decoration not in", values, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationBetween(String value1, String value2) {
            addCriterion("decoration between", value1, value2, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotBetween(String value1, String value2) {
            addCriterion("decoration not between", value1, value2, "decoration");
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

        public Criteria andPropertyYearIsNull() {
            addCriterion("property_year is null");
            return (Criteria) this;
        }

        public Criteria andPropertyYearIsNotNull() {
            addCriterion("property_year is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyYearEqualTo(String value) {
            addCriterion("property_year =", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearNotEqualTo(String value) {
            addCriterion("property_year <>", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearGreaterThan(String value) {
            addCriterion("property_year >", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearGreaterThanOrEqualTo(String value) {
            addCriterion("property_year >=", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearLessThan(String value) {
            addCriterion("property_year <", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearLessThanOrEqualTo(String value) {
            addCriterion("property_year <=", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearLike(String value) {
            addCriterion("property_year like", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearNotLike(String value) {
            addCriterion("property_year not like", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearIn(List<String> values) {
            addCriterion("property_year in", values, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearNotIn(List<String> values) {
            addCriterion("property_year not in", values, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearBetween(String value1, String value2) {
            addCriterion("property_year between", value1, value2, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearNotBetween(String value1, String value2) {
            addCriterion("property_year not between", value1, value2, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andTradingRightsIsNull() {
            addCriterion("trading_rights is null");
            return (Criteria) this;
        }

        public Criteria andTradingRightsIsNotNull() {
            addCriterion("trading_rights is not null");
            return (Criteria) this;
        }

        public Criteria andTradingRightsEqualTo(String value) {
            addCriterion("trading_rights =", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsNotEqualTo(String value) {
            addCriterion("trading_rights <>", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsGreaterThan(String value) {
            addCriterion("trading_rights >", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsGreaterThanOrEqualTo(String value) {
            addCriterion("trading_rights >=", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsLessThan(String value) {
            addCriterion("trading_rights <", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsLessThanOrEqualTo(String value) {
            addCriterion("trading_rights <=", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsLike(String value) {
            addCriterion("trading_rights like", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsNotLike(String value) {
            addCriterion("trading_rights not like", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsIn(List<String> values) {
            addCriterion("trading_rights in", values, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsNotIn(List<String> values) {
            addCriterion("trading_rights not in", values, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsBetween(String value1, String value2) {
            addCriterion("trading_rights between", value1, value2, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsNotBetween(String value1, String value2) {
            addCriterion("trading_rights not between", value1, value2, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andElevatorIsNull() {
            addCriterion("elevator is null");
            return (Criteria) this;
        }

        public Criteria andElevatorIsNotNull() {
            addCriterion("elevator is not null");
            return (Criteria) this;
        }

        public Criteria andElevatorEqualTo(String value) {
            addCriterion("elevator =", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorNotEqualTo(String value) {
            addCriterion("elevator <>", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorGreaterThan(String value) {
            addCriterion("elevator >", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorGreaterThanOrEqualTo(String value) {
            addCriterion("elevator >=", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorLessThan(String value) {
            addCriterion("elevator <", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorLessThanOrEqualTo(String value) {
            addCriterion("elevator <=", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorLike(String value) {
            addCriterion("elevator like", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorNotLike(String value) {
            addCriterion("elevator not like", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorIn(List<String> values) {
            addCriterion("elevator in", values, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorNotIn(List<String> values) {
            addCriterion("elevator not in", values, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorBetween(String value1, String value2) {
            addCriterion("elevator between", value1, value2, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorNotBetween(String value1, String value2) {
            addCriterion("elevator not between", value1, value2, "elevator");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityIsNull() {
            addCriterion("proprietor_mentality is null");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityIsNotNull() {
            addCriterion("proprietor_mentality is not null");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityEqualTo(String value) {
            addCriterion("proprietor_mentality =", value, "proprietorMentality");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityNotEqualTo(String value) {
            addCriterion("proprietor_mentality <>", value, "proprietorMentality");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityGreaterThan(String value) {
            addCriterion("proprietor_mentality >", value, "proprietorMentality");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityGreaterThanOrEqualTo(String value) {
            addCriterion("proprietor_mentality >=", value, "proprietorMentality");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityLessThan(String value) {
            addCriterion("proprietor_mentality <", value, "proprietorMentality");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityLessThanOrEqualTo(String value) {
            addCriterion("proprietor_mentality <=", value, "proprietorMentality");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityLike(String value) {
            addCriterion("proprietor_mentality like", value, "proprietorMentality");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityNotLike(String value) {
            addCriterion("proprietor_mentality not like", value, "proprietorMentality");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityIn(List<String> values) {
            addCriterion("proprietor_mentality in", values, "proprietorMentality");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityNotIn(List<String> values) {
            addCriterion("proprietor_mentality not in", values, "proprietorMentality");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityBetween(String value1, String value2) {
            addCriterion("proprietor_mentality between", value1, value2, "proprietorMentality");
            return (Criteria) this;
        }

        public Criteria andProprietorMentalityNotBetween(String value1, String value2) {
            addCriterion("proprietor_mentality not between", value1, value2, "proprietorMentality");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingIsNull() {
            addCriterion("community_matching is null");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingIsNotNull() {
            addCriterion("community_matching is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingEqualTo(String value) {
            addCriterion("community_matching =", value, "communityMatching");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingNotEqualTo(String value) {
            addCriterion("community_matching <>", value, "communityMatching");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingGreaterThan(String value) {
            addCriterion("community_matching >", value, "communityMatching");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingGreaterThanOrEqualTo(String value) {
            addCriterion("community_matching >=", value, "communityMatching");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingLessThan(String value) {
            addCriterion("community_matching <", value, "communityMatching");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingLessThanOrEqualTo(String value) {
            addCriterion("community_matching <=", value, "communityMatching");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingLike(String value) {
            addCriterion("community_matching like", value, "communityMatching");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingNotLike(String value) {
            addCriterion("community_matching not like", value, "communityMatching");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingIn(List<String> values) {
            addCriterion("community_matching in", values, "communityMatching");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingNotIn(List<String> values) {
            addCriterion("community_matching not in", values, "communityMatching");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingBetween(String value1, String value2) {
            addCriterion("community_matching between", value1, value2, "communityMatching");
            return (Criteria) this;
        }

        public Criteria andCommunityMatchingNotBetween(String value1, String value2) {
            addCriterion("community_matching not between", value1, value2, "communityMatching");
            return (Criteria) this;
        }

        public Criteria andServiceTagIsNull() {
            addCriterion("service_tag is null");
            return (Criteria) this;
        }

        public Criteria andServiceTagIsNotNull() {
            addCriterion("service_tag is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTagEqualTo(String value) {
            addCriterion("service_tag =", value, "serviceTag");
            return (Criteria) this;
        }

        public Criteria andServiceTagNotEqualTo(String value) {
            addCriterion("service_tag <>", value, "serviceTag");
            return (Criteria) this;
        }

        public Criteria andServiceTagGreaterThan(String value) {
            addCriterion("service_tag >", value, "serviceTag");
            return (Criteria) this;
        }

        public Criteria andServiceTagGreaterThanOrEqualTo(String value) {
            addCriterion("service_tag >=", value, "serviceTag");
            return (Criteria) this;
        }

        public Criteria andServiceTagLessThan(String value) {
            addCriterion("service_tag <", value, "serviceTag");
            return (Criteria) this;
        }

        public Criteria andServiceTagLessThanOrEqualTo(String value) {
            addCriterion("service_tag <=", value, "serviceTag");
            return (Criteria) this;
        }

        public Criteria andServiceTagLike(String value) {
            addCriterion("service_tag like", value, "serviceTag");
            return (Criteria) this;
        }

        public Criteria andServiceTagNotLike(String value) {
            addCriterion("service_tag not like", value, "serviceTag");
            return (Criteria) this;
        }

        public Criteria andServiceTagIn(List<String> values) {
            addCriterion("service_tag in", values, "serviceTag");
            return (Criteria) this;
        }

        public Criteria andServiceTagNotIn(List<String> values) {
            addCriterion("service_tag not in", values, "serviceTag");
            return (Criteria) this;
        }

        public Criteria andServiceTagBetween(String value1, String value2) {
            addCriterion("service_tag between", value1, value2, "serviceTag");
            return (Criteria) this;
        }

        public Criteria andServiceTagNotBetween(String value1, String value2) {
            addCriterion("service_tag not between", value1, value2, "serviceTag");
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