package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GovernmentLoudongExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GovernmentLoudongExample() {
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

        public Criteria andSalesNoIsNull() {
            addCriterion("sales_no is null");
            return (Criteria) this;
        }

        public Criteria andSalesNoIsNotNull() {
            addCriterion("sales_no is not null");
            return (Criteria) this;
        }

        public Criteria andSalesNoEqualTo(String value) {
            addCriterion("sales_no =", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoNotEqualTo(String value) {
            addCriterion("sales_no <>", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoGreaterThan(String value) {
            addCriterion("sales_no >", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoGreaterThanOrEqualTo(String value) {
            addCriterion("sales_no >=", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoLessThan(String value) {
            addCriterion("sales_no <", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoLessThanOrEqualTo(String value) {
            addCriterion("sales_no <=", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoLike(String value) {
            addCriterion("sales_no like", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoNotLike(String value) {
            addCriterion("sales_no not like", value, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoIn(List<String> values) {
            addCriterion("sales_no in", values, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoNotIn(List<String> values) {
            addCriterion("sales_no not in", values, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoBetween(String value1, String value2) {
            addCriterion("sales_no between", value1, value2, "salesNo");
            return (Criteria) this;
        }

        public Criteria andSalesNoNotBetween(String value1, String value2) {
            addCriterion("sales_no not between", value1, value2, "salesNo");
            return (Criteria) this;
        }

        public Criteria andTitleRelationIsNull() {
            addCriterion("title_relation is null");
            return (Criteria) this;
        }

        public Criteria andTitleRelationIsNotNull() {
            addCriterion("title_relation is not null");
            return (Criteria) this;
        }

        public Criteria andTitleRelationEqualTo(String value) {
            addCriterion("title_relation =", value, "titleRelation");
            return (Criteria) this;
        }

        public Criteria andTitleRelationNotEqualTo(String value) {
            addCriterion("title_relation <>", value, "titleRelation");
            return (Criteria) this;
        }

        public Criteria andTitleRelationGreaterThan(String value) {
            addCriterion("title_relation >", value, "titleRelation");
            return (Criteria) this;
        }

        public Criteria andTitleRelationGreaterThanOrEqualTo(String value) {
            addCriterion("title_relation >=", value, "titleRelation");
            return (Criteria) this;
        }

        public Criteria andTitleRelationLessThan(String value) {
            addCriterion("title_relation <", value, "titleRelation");
            return (Criteria) this;
        }

        public Criteria andTitleRelationLessThanOrEqualTo(String value) {
            addCriterion("title_relation <=", value, "titleRelation");
            return (Criteria) this;
        }

        public Criteria andTitleRelationLike(String value) {
            addCriterion("title_relation like", value, "titleRelation");
            return (Criteria) this;
        }

        public Criteria andTitleRelationNotLike(String value) {
            addCriterion("title_relation not like", value, "titleRelation");
            return (Criteria) this;
        }

        public Criteria andTitleRelationIn(List<String> values) {
            addCriterion("title_relation in", values, "titleRelation");
            return (Criteria) this;
        }

        public Criteria andTitleRelationNotIn(List<String> values) {
            addCriterion("title_relation not in", values, "titleRelation");
            return (Criteria) this;
        }

        public Criteria andTitleRelationBetween(String value1, String value2) {
            addCriterion("title_relation between", value1, value2, "titleRelation");
            return (Criteria) this;
        }

        public Criteria andTitleRelationNotBetween(String value1, String value2) {
            addCriterion("title_relation not between", value1, value2, "titleRelation");
            return (Criteria) this;
        }

        public Criteria andBuildingIsNull() {
            addCriterion("building is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIsNotNull() {
            addCriterion("building is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingEqualTo(String value) {
            addCriterion("building =", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotEqualTo(String value) {
            addCriterion("building <>", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingGreaterThan(String value) {
            addCriterion("building >", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingGreaterThanOrEqualTo(String value) {
            addCriterion("building >=", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLessThan(String value) {
            addCriterion("building <", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLessThanOrEqualTo(String value) {
            addCriterion("building <=", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLike(String value) {
            addCriterion("building like", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotLike(String value) {
            addCriterion("building not like", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingIn(List<String> values) {
            addCriterion("building in", values, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotIn(List<String> values) {
            addCriterion("building not in", values, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingBetween(String value1, String value2) {
            addCriterion("building between", value1, value2, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotBetween(String value1, String value2) {
            addCriterion("building not between", value1, value2, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNull() {
            addCriterion("building_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("building_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(String value) {
            addCriterion("building_id =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(String value) {
            addCriterion("building_id <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(String value) {
            addCriterion("building_id >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(String value) {
            addCriterion("building_id >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(String value) {
            addCriterion("building_id <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(String value) {
            addCriterion("building_id <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLike(String value) {
            addCriterion("building_id like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotLike(String value) {
            addCriterion("building_id not like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<String> values) {
            addCriterion("building_id in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<String> values) {
            addCriterion("building_id not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(String value1, String value2) {
            addCriterion("building_id between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(String value1, String value2) {
            addCriterion("building_id not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andSaleHouseIsNull() {
            addCriterion("sale_house is null");
            return (Criteria) this;
        }

        public Criteria andSaleHouseIsNotNull() {
            addCriterion("sale_house is not null");
            return (Criteria) this;
        }

        public Criteria andSaleHouseEqualTo(String value) {
            addCriterion("sale_house =", value, "saleHouse");
            return (Criteria) this;
        }

        public Criteria andSaleHouseNotEqualTo(String value) {
            addCriterion("sale_house <>", value, "saleHouse");
            return (Criteria) this;
        }

        public Criteria andSaleHouseGreaterThan(String value) {
            addCriterion("sale_house >", value, "saleHouse");
            return (Criteria) this;
        }

        public Criteria andSaleHouseGreaterThanOrEqualTo(String value) {
            addCriterion("sale_house >=", value, "saleHouse");
            return (Criteria) this;
        }

        public Criteria andSaleHouseLessThan(String value) {
            addCriterion("sale_house <", value, "saleHouse");
            return (Criteria) this;
        }

        public Criteria andSaleHouseLessThanOrEqualTo(String value) {
            addCriterion("sale_house <=", value, "saleHouse");
            return (Criteria) this;
        }

        public Criteria andSaleHouseLike(String value) {
            addCriterion("sale_house like", value, "saleHouse");
            return (Criteria) this;
        }

        public Criteria andSaleHouseNotLike(String value) {
            addCriterion("sale_house not like", value, "saleHouse");
            return (Criteria) this;
        }

        public Criteria andSaleHouseIn(List<String> values) {
            addCriterion("sale_house in", values, "saleHouse");
            return (Criteria) this;
        }

        public Criteria andSaleHouseNotIn(List<String> values) {
            addCriterion("sale_house not in", values, "saleHouse");
            return (Criteria) this;
        }

        public Criteria andSaleHouseBetween(String value1, String value2) {
            addCriterion("sale_house between", value1, value2, "saleHouse");
            return (Criteria) this;
        }

        public Criteria andSaleHouseNotBetween(String value1, String value2) {
            addCriterion("sale_house not between", value1, value2, "saleHouse");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseIsNull() {
            addCriterion("sale_nothouse is null");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseIsNotNull() {
            addCriterion("sale_nothouse is not null");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseEqualTo(String value) {
            addCriterion("sale_nothouse =", value, "saleNothouse");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseNotEqualTo(String value) {
            addCriterion("sale_nothouse <>", value, "saleNothouse");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseGreaterThan(String value) {
            addCriterion("sale_nothouse >", value, "saleNothouse");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseGreaterThanOrEqualTo(String value) {
            addCriterion("sale_nothouse >=", value, "saleNothouse");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseLessThan(String value) {
            addCriterion("sale_nothouse <", value, "saleNothouse");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseLessThanOrEqualTo(String value) {
            addCriterion("sale_nothouse <=", value, "saleNothouse");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseLike(String value) {
            addCriterion("sale_nothouse like", value, "saleNothouse");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseNotLike(String value) {
            addCriterion("sale_nothouse not like", value, "saleNothouse");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseIn(List<String> values) {
            addCriterion("sale_nothouse in", values, "saleNothouse");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseNotIn(List<String> values) {
            addCriterion("sale_nothouse not in", values, "saleNothouse");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseBetween(String value1, String value2) {
            addCriterion("sale_nothouse between", value1, value2, "saleNothouse");
            return (Criteria) this;
        }

        public Criteria andSaleNothouseNotBetween(String value1, String value2) {
            addCriterion("sale_nothouse not between", value1, value2, "saleNothouse");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlIsNull() {
            addCriterion("loudong_url is null");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlIsNotNull() {
            addCriterion("loudong_url is not null");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlEqualTo(String value) {
            addCriterion("loudong_url =", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlNotEqualTo(String value) {
            addCriterion("loudong_url <>", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlGreaterThan(String value) {
            addCriterion("loudong_url >", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlGreaterThanOrEqualTo(String value) {
            addCriterion("loudong_url >=", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlLessThan(String value) {
            addCriterion("loudong_url <", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlLessThanOrEqualTo(String value) {
            addCriterion("loudong_url <=", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlLike(String value) {
            addCriterion("loudong_url like", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlNotLike(String value) {
            addCriterion("loudong_url not like", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlIn(List<String> values) {
            addCriterion("loudong_url in", values, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlNotIn(List<String> values) {
            addCriterion("loudong_url not in", values, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlBetween(String value1, String value2) {
            addCriterion("loudong_url between", value1, value2, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlNotBetween(String value1, String value2) {
            addCriterion("loudong_url not between", value1, value2, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andRealFloorIsNull() {
            addCriterion("real_floor is null");
            return (Criteria) this;
        }

        public Criteria andRealFloorIsNotNull() {
            addCriterion("real_floor is not null");
            return (Criteria) this;
        }

        public Criteria andRealFloorEqualTo(String value) {
            addCriterion("real_floor =", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorNotEqualTo(String value) {
            addCriterion("real_floor <>", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorGreaterThan(String value) {
            addCriterion("real_floor >", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorGreaterThanOrEqualTo(String value) {
            addCriterion("real_floor >=", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorLessThan(String value) {
            addCriterion("real_floor <", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorLessThanOrEqualTo(String value) {
            addCriterion("real_floor <=", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorLike(String value) {
            addCriterion("real_floor like", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorNotLike(String value) {
            addCriterion("real_floor not like", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorIn(List<String> values) {
            addCriterion("real_floor in", values, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorNotIn(List<String> values) {
            addCriterion("real_floor not in", values, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorBetween(String value1, String value2) {
            addCriterion("real_floor between", value1, value2, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorNotBetween(String value1, String value2) {
            addCriterion("real_floor not between", value1, value2, "realFloor");
            return (Criteria) this;
        }

        public Criteria andNominalFloorIsNull() {
            addCriterion("nominal_floor is null");
            return (Criteria) this;
        }

        public Criteria andNominalFloorIsNotNull() {
            addCriterion("nominal_floor is not null");
            return (Criteria) this;
        }

        public Criteria andNominalFloorEqualTo(String value) {
            addCriterion("nominal_floor =", value, "nominalFloor");
            return (Criteria) this;
        }

        public Criteria andNominalFloorNotEqualTo(String value) {
            addCriterion("nominal_floor <>", value, "nominalFloor");
            return (Criteria) this;
        }

        public Criteria andNominalFloorGreaterThan(String value) {
            addCriterion("nominal_floor >", value, "nominalFloor");
            return (Criteria) this;
        }

        public Criteria andNominalFloorGreaterThanOrEqualTo(String value) {
            addCriterion("nominal_floor >=", value, "nominalFloor");
            return (Criteria) this;
        }

        public Criteria andNominalFloorLessThan(String value) {
            addCriterion("nominal_floor <", value, "nominalFloor");
            return (Criteria) this;
        }

        public Criteria andNominalFloorLessThanOrEqualTo(String value) {
            addCriterion("nominal_floor <=", value, "nominalFloor");
            return (Criteria) this;
        }

        public Criteria andNominalFloorLike(String value) {
            addCriterion("nominal_floor like", value, "nominalFloor");
            return (Criteria) this;
        }

        public Criteria andNominalFloorNotLike(String value) {
            addCriterion("nominal_floor not like", value, "nominalFloor");
            return (Criteria) this;
        }

        public Criteria andNominalFloorIn(List<String> values) {
            addCriterion("nominal_floor in", values, "nominalFloor");
            return (Criteria) this;
        }

        public Criteria andNominalFloorNotIn(List<String> values) {
            addCriterion("nominal_floor not in", values, "nominalFloor");
            return (Criteria) this;
        }

        public Criteria andNominalFloorBetween(String value1, String value2) {
            addCriterion("nominal_floor between", value1, value2, "nominalFloor");
            return (Criteria) this;
        }

        public Criteria andNominalFloorNotBetween(String value1, String value2) {
            addCriterion("nominal_floor not between", value1, value2, "nominalFloor");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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