package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LianjiaListingHouseDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LianjiaListingHouseDetailExample() {
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

        public Criteria andGoodsDesIsNull() {
            addCriterion("goods_des is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDesIsNotNull() {
            addCriterion("goods_des is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDesEqualTo(String value) {
            addCriterion("goods_des =", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesNotEqualTo(String value) {
            addCriterion("goods_des <>", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesGreaterThan(String value) {
            addCriterion("goods_des >", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesGreaterThanOrEqualTo(String value) {
            addCriterion("goods_des >=", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesLessThan(String value) {
            addCriterion("goods_des <", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesLessThanOrEqualTo(String value) {
            addCriterion("goods_des <=", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesLike(String value) {
            addCriterion("goods_des like", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesNotLike(String value) {
            addCriterion("goods_des not like", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesIn(List<String> values) {
            addCriterion("goods_des in", values, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesNotIn(List<String> values) {
            addCriterion("goods_des not in", values, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesBetween(String value1, String value2) {
            addCriterion("goods_des between", value1, value2, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesNotBetween(String value1, String value2) {
            addCriterion("goods_des not between", value1, value2, "goodsDes");
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

        public Criteria andLoopPositionIsNull() {
            addCriterion("loop_position is null");
            return (Criteria) this;
        }

        public Criteria andLoopPositionIsNotNull() {
            addCriterion("loop_position is not null");
            return (Criteria) this;
        }

        public Criteria andLoopPositionEqualTo(String value) {
            addCriterion("loop_position =", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionNotEqualTo(String value) {
            addCriterion("loop_position <>", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionGreaterThan(String value) {
            addCriterion("loop_position >", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionGreaterThanOrEqualTo(String value) {
            addCriterion("loop_position >=", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionLessThan(String value) {
            addCriterion("loop_position <", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionLessThanOrEqualTo(String value) {
            addCriterion("loop_position <=", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionLike(String value) {
            addCriterion("loop_position like", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionNotLike(String value) {
            addCriterion("loop_position not like", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionIn(List<String> values) {
            addCriterion("loop_position in", values, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionNotIn(List<String> values) {
            addCriterion("loop_position not in", values, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionBetween(String value1, String value2) {
            addCriterion("loop_position between", value1, value2, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionNotBetween(String value1, String value2) {
            addCriterion("loop_position not between", value1, value2, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andSubwayIsNull() {
            addCriterion("subway is null");
            return (Criteria) this;
        }

        public Criteria andSubwayIsNotNull() {
            addCriterion("subway is not null");
            return (Criteria) this;
        }

        public Criteria andSubwayEqualTo(String value) {
            addCriterion("subway =", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayNotEqualTo(String value) {
            addCriterion("subway <>", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayGreaterThan(String value) {
            addCriterion("subway >", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayGreaterThanOrEqualTo(String value) {
            addCriterion("subway >=", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayLessThan(String value) {
            addCriterion("subway <", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayLessThanOrEqualTo(String value) {
            addCriterion("subway <=", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayLike(String value) {
            addCriterion("subway like", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayNotLike(String value) {
            addCriterion("subway not like", value, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayIn(List<String> values) {
            addCriterion("subway in", values, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayNotIn(List<String> values) {
            addCriterion("subway not in", values, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayBetween(String value1, String value2) {
            addCriterion("subway between", value1, value2, "subway");
            return (Criteria) this;
        }

        public Criteria andSubwayNotBetween(String value1, String value2) {
            addCriterion("subway not between", value1, value2, "subway");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionIsNull() {
            addCriterion("watch_description is null");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionIsNotNull() {
            addCriterion("watch_description is not null");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionEqualTo(String value) {
            addCriterion("watch_description =", value, "watchDescription");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionNotEqualTo(String value) {
            addCriterion("watch_description <>", value, "watchDescription");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionGreaterThan(String value) {
            addCriterion("watch_description >", value, "watchDescription");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("watch_description >=", value, "watchDescription");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionLessThan(String value) {
            addCriterion("watch_description <", value, "watchDescription");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionLessThanOrEqualTo(String value) {
            addCriterion("watch_description <=", value, "watchDescription");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionLike(String value) {
            addCriterion("watch_description like", value, "watchDescription");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionNotLike(String value) {
            addCriterion("watch_description not like", value, "watchDescription");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionIn(List<String> values) {
            addCriterion("watch_description in", values, "watchDescription");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionNotIn(List<String> values) {
            addCriterion("watch_description not in", values, "watchDescription");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionBetween(String value1, String value2) {
            addCriterion("watch_description between", value1, value2, "watchDescription");
            return (Criteria) this;
        }

        public Criteria andWatchDescriptionNotBetween(String value1, String value2) {
            addCriterion("watch_description not between", value1, value2, "watchDescription");
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

        public Criteria andTotalFloorIsNull() {
            addCriterion("total_floor is null");
            return (Criteria) this;
        }

        public Criteria andTotalFloorIsNotNull() {
            addCriterion("total_floor is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFloorEqualTo(String value) {
            addCriterion("total_floor =", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorNotEqualTo(String value) {
            addCriterion("total_floor <>", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorGreaterThan(String value) {
            addCriterion("total_floor >", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorGreaterThanOrEqualTo(String value) {
            addCriterion("total_floor >=", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorLessThan(String value) {
            addCriterion("total_floor <", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorLessThanOrEqualTo(String value) {
            addCriterion("total_floor <=", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorLike(String value) {
            addCriterion("total_floor like", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorNotLike(String value) {
            addCriterion("total_floor not like", value, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorIn(List<String> values) {
            addCriterion("total_floor in", values, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorNotIn(List<String> values) {
            addCriterion("total_floor not in", values, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorBetween(String value1, String value2) {
            addCriterion("total_floor between", value1, value2, "totalFloor");
            return (Criteria) this;
        }

        public Criteria andTotalFloorNotBetween(String value1, String value2) {
            addCriterion("total_floor not between", value1, value2, "totalFloor");
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

        public Criteria andDwellingFloorSpaceIsNull() {
            addCriterion("dwelling_floor_space is null");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceIsNotNull() {
            addCriterion("dwelling_floor_space is not null");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceEqualTo(String value) {
            addCriterion("dwelling_floor_space =", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceNotEqualTo(String value) {
            addCriterion("dwelling_floor_space <>", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceGreaterThan(String value) {
            addCriterion("dwelling_floor_space >", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceGreaterThanOrEqualTo(String value) {
            addCriterion("dwelling_floor_space >=", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceLessThan(String value) {
            addCriterion("dwelling_floor_space <", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceLessThanOrEqualTo(String value) {
            addCriterion("dwelling_floor_space <=", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceLike(String value) {
            addCriterion("dwelling_floor_space like", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceNotLike(String value) {
            addCriterion("dwelling_floor_space not like", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceIn(List<String> values) {
            addCriterion("dwelling_floor_space in", values, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceNotIn(List<String> values) {
            addCriterion("dwelling_floor_space not in", values, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceBetween(String value1, String value2) {
            addCriterion("dwelling_floor_space between", value1, value2, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceNotBetween(String value1, String value2) {
            addCriterion("dwelling_floor_space not between", value1, value2, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andBuildTypeIsNull() {
            addCriterion("build_type is null");
            return (Criteria) this;
        }

        public Criteria andBuildTypeIsNotNull() {
            addCriterion("build_type is not null");
            return (Criteria) this;
        }

        public Criteria andBuildTypeEqualTo(String value) {
            addCriterion("build_type =", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeNotEqualTo(String value) {
            addCriterion("build_type <>", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeGreaterThan(String value) {
            addCriterion("build_type >", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeGreaterThanOrEqualTo(String value) {
            addCriterion("build_type >=", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeLessThan(String value) {
            addCriterion("build_type <", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeLessThanOrEqualTo(String value) {
            addCriterion("build_type <=", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeLike(String value) {
            addCriterion("build_type like", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeNotLike(String value) {
            addCriterion("build_type not like", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeIn(List<String> values) {
            addCriterion("build_type in", values, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeNotIn(List<String> values) {
            addCriterion("build_type not in", values, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeBetween(String value1, String value2) {
            addCriterion("build_type between", value1, value2, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeNotBetween(String value1, String value2) {
            addCriterion("build_type not between", value1, value2, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildStrIsNull() {
            addCriterion("build_str is null");
            return (Criteria) this;
        }

        public Criteria andBuildStrIsNotNull() {
            addCriterion("build_str is not null");
            return (Criteria) this;
        }

        public Criteria andBuildStrEqualTo(String value) {
            addCriterion("build_str =", value, "buildStr");
            return (Criteria) this;
        }

        public Criteria andBuildStrNotEqualTo(String value) {
            addCriterion("build_str <>", value, "buildStr");
            return (Criteria) this;
        }

        public Criteria andBuildStrGreaterThan(String value) {
            addCriterion("build_str >", value, "buildStr");
            return (Criteria) this;
        }

        public Criteria andBuildStrGreaterThanOrEqualTo(String value) {
            addCriterion("build_str >=", value, "buildStr");
            return (Criteria) this;
        }

        public Criteria andBuildStrLessThan(String value) {
            addCriterion("build_str <", value, "buildStr");
            return (Criteria) this;
        }

        public Criteria andBuildStrLessThanOrEqualTo(String value) {
            addCriterion("build_str <=", value, "buildStr");
            return (Criteria) this;
        }

        public Criteria andBuildStrLike(String value) {
            addCriterion("build_str like", value, "buildStr");
            return (Criteria) this;
        }

        public Criteria andBuildStrNotLike(String value) {
            addCriterion("build_str not like", value, "buildStr");
            return (Criteria) this;
        }

        public Criteria andBuildStrIn(List<String> values) {
            addCriterion("build_str in", values, "buildStr");
            return (Criteria) this;
        }

        public Criteria andBuildStrNotIn(List<String> values) {
            addCriterion("build_str not in", values, "buildStr");
            return (Criteria) this;
        }

        public Criteria andBuildStrBetween(String value1, String value2) {
            addCriterion("build_str between", value1, value2, "buildStr");
            return (Criteria) this;
        }

        public Criteria andBuildStrNotBetween(String value1, String value2) {
            addCriterion("build_str not between", value1, value2, "buildStr");
            return (Criteria) this;
        }

        public Criteria andOrientationIsNull() {
            addCriterion("orientation is null");
            return (Criteria) this;
        }

        public Criteria andOrientationIsNotNull() {
            addCriterion("orientation is not null");
            return (Criteria) this;
        }

        public Criteria andOrientationEqualTo(String value) {
            addCriterion("orientation =", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationNotEqualTo(String value) {
            addCriterion("orientation <>", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationGreaterThan(String value) {
            addCriterion("orientation >", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationGreaterThanOrEqualTo(String value) {
            addCriterion("orientation >=", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationLessThan(String value) {
            addCriterion("orientation <", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationLessThanOrEqualTo(String value) {
            addCriterion("orientation <=", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationLike(String value) {
            addCriterion("orientation like", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationNotLike(String value) {
            addCriterion("orientation not like", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationIn(List<String> values) {
            addCriterion("orientation in", values, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationNotIn(List<String> values) {
            addCriterion("orientation not in", values, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationBetween(String value1, String value2) {
            addCriterion("orientation between", value1, value2, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationNotBetween(String value1, String value2) {
            addCriterion("orientation not between", value1, value2, "orientation");
            return (Criteria) this;
        }

        public Criteria andLayoutStrIsNull() {
            addCriterion("layout_str is null");
            return (Criteria) this;
        }

        public Criteria andLayoutStrIsNotNull() {
            addCriterion("layout_str is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutStrEqualTo(String value) {
            addCriterion("layout_str =", value, "layoutStr");
            return (Criteria) this;
        }

        public Criteria andLayoutStrNotEqualTo(String value) {
            addCriterion("layout_str <>", value, "layoutStr");
            return (Criteria) this;
        }

        public Criteria andLayoutStrGreaterThan(String value) {
            addCriterion("layout_str >", value, "layoutStr");
            return (Criteria) this;
        }

        public Criteria andLayoutStrGreaterThanOrEqualTo(String value) {
            addCriterion("layout_str >=", value, "layoutStr");
            return (Criteria) this;
        }

        public Criteria andLayoutStrLessThan(String value) {
            addCriterion("layout_str <", value, "layoutStr");
            return (Criteria) this;
        }

        public Criteria andLayoutStrLessThanOrEqualTo(String value) {
            addCriterion("layout_str <=", value, "layoutStr");
            return (Criteria) this;
        }

        public Criteria andLayoutStrLike(String value) {
            addCriterion("layout_str like", value, "layoutStr");
            return (Criteria) this;
        }

        public Criteria andLayoutStrNotLike(String value) {
            addCriterion("layout_str not like", value, "layoutStr");
            return (Criteria) this;
        }

        public Criteria andLayoutStrIn(List<String> values) {
            addCriterion("layout_str in", values, "layoutStr");
            return (Criteria) this;
        }

        public Criteria andLayoutStrNotIn(List<String> values) {
            addCriterion("layout_str not in", values, "layoutStr");
            return (Criteria) this;
        }

        public Criteria andLayoutStrBetween(String value1, String value2) {
            addCriterion("layout_str between", value1, value2, "layoutStr");
            return (Criteria) this;
        }

        public Criteria andLayoutStrNotBetween(String value1, String value2) {
            addCriterion("layout_str not between", value1, value2, "layoutStr");
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

        public Criteria andHeatingIsNull() {
            addCriterion("heating is null");
            return (Criteria) this;
        }

        public Criteria andHeatingIsNotNull() {
            addCriterion("heating is not null");
            return (Criteria) this;
        }

        public Criteria andHeatingEqualTo(String value) {
            addCriterion("heating =", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingNotEqualTo(String value) {
            addCriterion("heating <>", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingGreaterThan(String value) {
            addCriterion("heating >", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingGreaterThanOrEqualTo(String value) {
            addCriterion("heating >=", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingLessThan(String value) {
            addCriterion("heating <", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingLessThanOrEqualTo(String value) {
            addCriterion("heating <=", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingLike(String value) {
            addCriterion("heating like", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingNotLike(String value) {
            addCriterion("heating not like", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingIn(List<String> values) {
            addCriterion("heating in", values, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingNotIn(List<String> values) {
            addCriterion("heating not in", values, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingBetween(String value1, String value2) {
            addCriterion("heating between", value1, value2, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingNotBetween(String value1, String value2) {
            addCriterion("heating not between", value1, value2, "heating");
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

        public Criteria andLadderRatioIsNull() {
            addCriterion("ladder_ratio is null");
            return (Criteria) this;
        }

        public Criteria andLadderRatioIsNotNull() {
            addCriterion("ladder_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andLadderRatioEqualTo(String value) {
            addCriterion("ladder_ratio =", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioNotEqualTo(String value) {
            addCriterion("ladder_ratio <>", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioGreaterThan(String value) {
            addCriterion("ladder_ratio >", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioGreaterThanOrEqualTo(String value) {
            addCriterion("ladder_ratio >=", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioLessThan(String value) {
            addCriterion("ladder_ratio <", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioLessThanOrEqualTo(String value) {
            addCriterion("ladder_ratio <=", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioLike(String value) {
            addCriterion("ladder_ratio like", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioNotLike(String value) {
            addCriterion("ladder_ratio not like", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioIn(List<String> values) {
            addCriterion("ladder_ratio in", values, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioNotIn(List<String> values) {
            addCriterion("ladder_ratio not in", values, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioBetween(String value1, String value2) {
            addCriterion("ladder_ratio between", value1, value2, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioNotBetween(String value1, String value2) {
            addCriterion("ladder_ratio not between", value1, value2, "ladderRatio");
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

        public Criteria andMortgageInformationIsNull() {
            addCriterion("mortgage_information is null");
            return (Criteria) this;
        }

        public Criteria andMortgageInformationIsNotNull() {
            addCriterion("mortgage_information is not null");
            return (Criteria) this;
        }

        public Criteria andMortgageInformationEqualTo(String value) {
            addCriterion("mortgage_information =", value, "mortgageInformation");
            return (Criteria) this;
        }

        public Criteria andMortgageInformationNotEqualTo(String value) {
            addCriterion("mortgage_information <>", value, "mortgageInformation");
            return (Criteria) this;
        }

        public Criteria andMortgageInformationGreaterThan(String value) {
            addCriterion("mortgage_information >", value, "mortgageInformation");
            return (Criteria) this;
        }

        public Criteria andMortgageInformationGreaterThanOrEqualTo(String value) {
            addCriterion("mortgage_information >=", value, "mortgageInformation");
            return (Criteria) this;
        }

        public Criteria andMortgageInformationLessThan(String value) {
            addCriterion("mortgage_information <", value, "mortgageInformation");
            return (Criteria) this;
        }

        public Criteria andMortgageInformationLessThanOrEqualTo(String value) {
            addCriterion("mortgage_information <=", value, "mortgageInformation");
            return (Criteria) this;
        }

        public Criteria andMortgageInformationLike(String value) {
            addCriterion("mortgage_information like", value, "mortgageInformation");
            return (Criteria) this;
        }

        public Criteria andMortgageInformationNotLike(String value) {
            addCriterion("mortgage_information not like", value, "mortgageInformation");
            return (Criteria) this;
        }

        public Criteria andMortgageInformationIn(List<String> values) {
            addCriterion("mortgage_information in", values, "mortgageInformation");
            return (Criteria) this;
        }

        public Criteria andMortgageInformationNotIn(List<String> values) {
            addCriterion("mortgage_information not in", values, "mortgageInformation");
            return (Criteria) this;
        }

        public Criteria andMortgageInformationBetween(String value1, String value2) {
            addCriterion("mortgage_information between", value1, value2, "mortgageInformation");
            return (Criteria) this;
        }

        public Criteria andMortgageInformationNotBetween(String value1, String value2) {
            addCriterion("mortgage_information not between", value1, value2, "mortgageInformation");
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

        public Criteria andPropertyOwnershipIsNull() {
            addCriterion("property_ownership is null");
            return (Criteria) this;
        }

        public Criteria andPropertyOwnershipIsNotNull() {
            addCriterion("property_ownership is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyOwnershipEqualTo(String value) {
            addCriterion("property_ownership =", value, "propertyOwnership");
            return (Criteria) this;
        }

        public Criteria andPropertyOwnershipNotEqualTo(String value) {
            addCriterion("property_ownership <>", value, "propertyOwnership");
            return (Criteria) this;
        }

        public Criteria andPropertyOwnershipGreaterThan(String value) {
            addCriterion("property_ownership >", value, "propertyOwnership");
            return (Criteria) this;
        }

        public Criteria andPropertyOwnershipGreaterThanOrEqualTo(String value) {
            addCriterion("property_ownership >=", value, "propertyOwnership");
            return (Criteria) this;
        }

        public Criteria andPropertyOwnershipLessThan(String value) {
            addCriterion("property_ownership <", value, "propertyOwnership");
            return (Criteria) this;
        }

        public Criteria andPropertyOwnershipLessThanOrEqualTo(String value) {
            addCriterion("property_ownership <=", value, "propertyOwnership");
            return (Criteria) this;
        }

        public Criteria andPropertyOwnershipLike(String value) {
            addCriterion("property_ownership like", value, "propertyOwnership");
            return (Criteria) this;
        }

        public Criteria andPropertyOwnershipNotLike(String value) {
            addCriterion("property_ownership not like", value, "propertyOwnership");
            return (Criteria) this;
        }

        public Criteria andPropertyOwnershipIn(List<String> values) {
            addCriterion("property_ownership in", values, "propertyOwnership");
            return (Criteria) this;
        }

        public Criteria andPropertyOwnershipNotIn(List<String> values) {
            addCriterion("property_ownership not in", values, "propertyOwnership");
            return (Criteria) this;
        }

        public Criteria andPropertyOwnershipBetween(String value1, String value2) {
            addCriterion("property_ownership between", value1, value2, "propertyOwnership");
            return (Criteria) this;
        }

        public Criteria andPropertyOwnershipNotBetween(String value1, String value2) {
            addCriterion("property_ownership not between", value1, value2, "propertyOwnership");
            return (Criteria) this;
        }

        public Criteria andIsCertificateIsNull() {
            addCriterion("is_certificate is null");
            return (Criteria) this;
        }

        public Criteria andIsCertificateIsNotNull() {
            addCriterion("is_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andIsCertificateEqualTo(String value) {
            addCriterion("is_certificate =", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateNotEqualTo(String value) {
            addCriterion("is_certificate <>", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateGreaterThan(String value) {
            addCriterion("is_certificate >", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("is_certificate >=", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateLessThan(String value) {
            addCriterion("is_certificate <", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateLessThanOrEqualTo(String value) {
            addCriterion("is_certificate <=", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateLike(String value) {
            addCriterion("is_certificate like", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateNotLike(String value) {
            addCriterion("is_certificate not like", value, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateIn(List<String> values) {
            addCriterion("is_certificate in", values, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateNotIn(List<String> values) {
            addCriterion("is_certificate not in", values, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateBetween(String value1, String value2) {
            addCriterion("is_certificate between", value1, value2, "isCertificate");
            return (Criteria) this;
        }

        public Criteria andIsCertificateNotBetween(String value1, String value2) {
            addCriterion("is_certificate not between", value1, value2, "isCertificate");
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

        public Criteria andGoodsLastselltimeIsNull() {
            addCriterion("goods_lastselltime is null");
            return (Criteria) this;
        }

        public Criteria andGoodsLastselltimeIsNotNull() {
            addCriterion("goods_lastselltime is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsLastselltimeEqualTo(String value) {
            addCriterion("goods_lastselltime =", value, "goodsLastselltime");
            return (Criteria) this;
        }

        public Criteria andGoodsLastselltimeNotEqualTo(String value) {
            addCriterion("goods_lastselltime <>", value, "goodsLastselltime");
            return (Criteria) this;
        }

        public Criteria andGoodsLastselltimeGreaterThan(String value) {
            addCriterion("goods_lastselltime >", value, "goodsLastselltime");
            return (Criteria) this;
        }

        public Criteria andGoodsLastselltimeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_lastselltime >=", value, "goodsLastselltime");
            return (Criteria) this;
        }

        public Criteria andGoodsLastselltimeLessThan(String value) {
            addCriterion("goods_lastselltime <", value, "goodsLastselltime");
            return (Criteria) this;
        }

        public Criteria andGoodsLastselltimeLessThanOrEqualTo(String value) {
            addCriterion("goods_lastselltime <=", value, "goodsLastselltime");
            return (Criteria) this;
        }

        public Criteria andGoodsLastselltimeLike(String value) {
            addCriterion("goods_lastselltime like", value, "goodsLastselltime");
            return (Criteria) this;
        }

        public Criteria andGoodsLastselltimeNotLike(String value) {
            addCriterion("goods_lastselltime not like", value, "goodsLastselltime");
            return (Criteria) this;
        }

        public Criteria andGoodsLastselltimeIn(List<String> values) {
            addCriterion("goods_lastselltime in", values, "goodsLastselltime");
            return (Criteria) this;
        }

        public Criteria andGoodsLastselltimeNotIn(List<String> values) {
            addCriterion("goods_lastselltime not in", values, "goodsLastselltime");
            return (Criteria) this;
        }

        public Criteria andGoodsLastselltimeBetween(String value1, String value2) {
            addCriterion("goods_lastselltime between", value1, value2, "goodsLastselltime");
            return (Criteria) this;
        }

        public Criteria andGoodsLastselltimeNotBetween(String value1, String value2) {
            addCriterion("goods_lastselltime not between", value1, value2, "goodsLastselltime");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcIsNull() {
            addCriterion("apartment_src is null");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcIsNotNull() {
            addCriterion("apartment_src is not null");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcEqualTo(String value) {
            addCriterion("apartment_src =", value, "apartmentSrc");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcNotEqualTo(String value) {
            addCriterion("apartment_src <>", value, "apartmentSrc");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcGreaterThan(String value) {
            addCriterion("apartment_src >", value, "apartmentSrc");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcGreaterThanOrEqualTo(String value) {
            addCriterion("apartment_src >=", value, "apartmentSrc");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcLessThan(String value) {
            addCriterion("apartment_src <", value, "apartmentSrc");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcLessThanOrEqualTo(String value) {
            addCriterion("apartment_src <=", value, "apartmentSrc");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcLike(String value) {
            addCriterion("apartment_src like", value, "apartmentSrc");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcNotLike(String value) {
            addCriterion("apartment_src not like", value, "apartmentSrc");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcIn(List<String> values) {
            addCriterion("apartment_src in", values, "apartmentSrc");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcNotIn(List<String> values) {
            addCriterion("apartment_src not in", values, "apartmentSrc");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcBetween(String value1, String value2) {
            addCriterion("apartment_src between", value1, value2, "apartmentSrc");
            return (Criteria) this;
        }

        public Criteria andApartmentSrcNotBetween(String value1, String value2) {
            addCriterion("apartment_src not between", value1, value2, "apartmentSrc");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlIsNull() {
            addCriterion("apartment_url is null");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlIsNotNull() {
            addCriterion("apartment_url is not null");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlEqualTo(String value) {
            addCriterion("apartment_url =", value, "apartmentUrl");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlNotEqualTo(String value) {
            addCriterion("apartment_url <>", value, "apartmentUrl");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlGreaterThan(String value) {
            addCriterion("apartment_url >", value, "apartmentUrl");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlGreaterThanOrEqualTo(String value) {
            addCriterion("apartment_url >=", value, "apartmentUrl");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlLessThan(String value) {
            addCriterion("apartment_url <", value, "apartmentUrl");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlLessThanOrEqualTo(String value) {
            addCriterion("apartment_url <=", value, "apartmentUrl");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlLike(String value) {
            addCriterion("apartment_url like", value, "apartmentUrl");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlNotLike(String value) {
            addCriterion("apartment_url not like", value, "apartmentUrl");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlIn(List<String> values) {
            addCriterion("apartment_url in", values, "apartmentUrl");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlNotIn(List<String> values) {
            addCriterion("apartment_url not in", values, "apartmentUrl");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlBetween(String value1, String value2) {
            addCriterion("apartment_url between", value1, value2, "apartmentUrl");
            return (Criteria) this;
        }

        public Criteria andApartmentUrlNotBetween(String value1, String value2) {
            addCriterion("apartment_url not between", value1, value2, "apartmentUrl");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNull() {
            addCriterion("view_count is null");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNotNull() {
            addCriterion("view_count is not null");
            return (Criteria) this;
        }

        public Criteria andViewCountEqualTo(String value) {
            addCriterion("view_count =", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotEqualTo(String value) {
            addCriterion("view_count <>", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThan(String value) {
            addCriterion("view_count >", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThanOrEqualTo(String value) {
            addCriterion("view_count >=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThan(String value) {
            addCriterion("view_count <", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThanOrEqualTo(String value) {
            addCriterion("view_count <=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLike(String value) {
            addCriterion("view_count like", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotLike(String value) {
            addCriterion("view_count not like", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountIn(List<String> values) {
            addCriterion("view_count in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotIn(List<String> values) {
            addCriterion("view_count not in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountBetween(String value1, String value2) {
            addCriterion("view_count between", value1, value2, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotBetween(String value1, String value2) {
            addCriterion("view_count not between", value1, value2, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysIsNull() {
            addCriterion("view_count_7days is null");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysIsNotNull() {
            addCriterion("view_count_7days is not null");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysEqualTo(String value) {
            addCriterion("view_count_7days =", value, "viewCount7days");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysNotEqualTo(String value) {
            addCriterion("view_count_7days <>", value, "viewCount7days");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysGreaterThan(String value) {
            addCriterion("view_count_7days >", value, "viewCount7days");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysGreaterThanOrEqualTo(String value) {
            addCriterion("view_count_7days >=", value, "viewCount7days");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysLessThan(String value) {
            addCriterion("view_count_7days <", value, "viewCount7days");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysLessThanOrEqualTo(String value) {
            addCriterion("view_count_7days <=", value, "viewCount7days");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysLike(String value) {
            addCriterion("view_count_7days like", value, "viewCount7days");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysNotLike(String value) {
            addCriterion("view_count_7days not like", value, "viewCount7days");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysIn(List<String> values) {
            addCriterion("view_count_7days in", values, "viewCount7days");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysNotIn(List<String> values) {
            addCriterion("view_count_7days not in", values, "viewCount7days");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysBetween(String value1, String value2) {
            addCriterion("view_count_7days between", value1, value2, "viewCount7days");
            return (Criteria) this;
        }

        public Criteria andViewCount7daysNotBetween(String value1, String value2) {
            addCriterion("view_count_7days not between", value1, value2, "viewCount7days");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysIsNull() {
            addCriterion("view_count_30days is null");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysIsNotNull() {
            addCriterion("view_count_30days is not null");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysEqualTo(String value) {
            addCriterion("view_count_30days =", value, "viewCount30days");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysNotEqualTo(String value) {
            addCriterion("view_count_30days <>", value, "viewCount30days");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysGreaterThan(String value) {
            addCriterion("view_count_30days >", value, "viewCount30days");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysGreaterThanOrEqualTo(String value) {
            addCriterion("view_count_30days >=", value, "viewCount30days");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysLessThan(String value) {
            addCriterion("view_count_30days <", value, "viewCount30days");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysLessThanOrEqualTo(String value) {
            addCriterion("view_count_30days <=", value, "viewCount30days");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysLike(String value) {
            addCriterion("view_count_30days like", value, "viewCount30days");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysNotLike(String value) {
            addCriterion("view_count_30days not like", value, "viewCount30days");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysIn(List<String> values) {
            addCriterion("view_count_30days in", values, "viewCount30days");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysNotIn(List<String> values) {
            addCriterion("view_count_30days not in", values, "viewCount30days");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysBetween(String value1, String value2) {
            addCriterion("view_count_30days between", value1, value2, "viewCount30days");
            return (Criteria) this;
        }

        public Criteria andViewCount30daysNotBetween(String value1, String value2) {
            addCriterion("view_count_30days not between", value1, value2, "viewCount30days");
            return (Criteria) this;
        }

        public Criteria andConcernCountIsNull() {
            addCriterion("concern_count is null");
            return (Criteria) this;
        }

        public Criteria andConcernCountIsNotNull() {
            addCriterion("concern_count is not null");
            return (Criteria) this;
        }

        public Criteria andConcernCountEqualTo(String value) {
            addCriterion("concern_count =", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountNotEqualTo(String value) {
            addCriterion("concern_count <>", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountGreaterThan(String value) {
            addCriterion("concern_count >", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountGreaterThanOrEqualTo(String value) {
            addCriterion("concern_count >=", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountLessThan(String value) {
            addCriterion("concern_count <", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountLessThanOrEqualTo(String value) {
            addCriterion("concern_count <=", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountLike(String value) {
            addCriterion("concern_count like", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountNotLike(String value) {
            addCriterion("concern_count not like", value, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountIn(List<String> values) {
            addCriterion("concern_count in", values, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountNotIn(List<String> values) {
            addCriterion("concern_count not in", values, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountBetween(String value1, String value2) {
            addCriterion("concern_count between", value1, value2, "concernCount");
            return (Criteria) this;
        }

        public Criteria andConcernCountNotBetween(String value1, String value2) {
            addCriterion("concern_count not between", value1, value2, "concernCount");
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

        public Criteria andBatchDescriptionIsNull() {
            addCriterion("batch_description is null");
            return (Criteria) this;
        }

        public Criteria andBatchDescriptionIsNotNull() {
            addCriterion("batch_description is not null");
            return (Criteria) this;
        }

        public Criteria andBatchDescriptionEqualTo(String value) {
            addCriterion("batch_description =", value, "batchDescription");
            return (Criteria) this;
        }

        public Criteria andBatchDescriptionNotEqualTo(String value) {
            addCriterion("batch_description <>", value, "batchDescription");
            return (Criteria) this;
        }

        public Criteria andBatchDescriptionGreaterThan(String value) {
            addCriterion("batch_description >", value, "batchDescription");
            return (Criteria) this;
        }

        public Criteria andBatchDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("batch_description >=", value, "batchDescription");
            return (Criteria) this;
        }

        public Criteria andBatchDescriptionLessThan(String value) {
            addCriterion("batch_description <", value, "batchDescription");
            return (Criteria) this;
        }

        public Criteria andBatchDescriptionLessThanOrEqualTo(String value) {
            addCriterion("batch_description <=", value, "batchDescription");
            return (Criteria) this;
        }

        public Criteria andBatchDescriptionLike(String value) {
            addCriterion("batch_description like", value, "batchDescription");
            return (Criteria) this;
        }

        public Criteria andBatchDescriptionNotLike(String value) {
            addCriterion("batch_description not like", value, "batchDescription");
            return (Criteria) this;
        }

        public Criteria andBatchDescriptionIn(List<String> values) {
            addCriterion("batch_description in", values, "batchDescription");
            return (Criteria) this;
        }

        public Criteria andBatchDescriptionNotIn(List<String> values) {
            addCriterion("batch_description not in", values, "batchDescription");
            return (Criteria) this;
        }

        public Criteria andBatchDescriptionBetween(String value1, String value2) {
            addCriterion("batch_description between", value1, value2, "batchDescription");
            return (Criteria) this;
        }

        public Criteria andBatchDescriptionNotBetween(String value1, String value2) {
            addCriterion("batch_description not between", value1, value2, "batchDescription");
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

        public Criteria andCreatUserIsNull() {
            addCriterion("creat_user is null");
            return (Criteria) this;
        }

        public Criteria andCreatUserIsNotNull() {
            addCriterion("creat_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreatUserEqualTo(String value) {
            addCriterion("creat_user =", value, "creatUser");
            return (Criteria) this;
        }

        public Criteria andCreatUserNotEqualTo(String value) {
            addCriterion("creat_user <>", value, "creatUser");
            return (Criteria) this;
        }

        public Criteria andCreatUserGreaterThan(String value) {
            addCriterion("creat_user >", value, "creatUser");
            return (Criteria) this;
        }

        public Criteria andCreatUserGreaterThanOrEqualTo(String value) {
            addCriterion("creat_user >=", value, "creatUser");
            return (Criteria) this;
        }

        public Criteria andCreatUserLessThan(String value) {
            addCriterion("creat_user <", value, "creatUser");
            return (Criteria) this;
        }

        public Criteria andCreatUserLessThanOrEqualTo(String value) {
            addCriterion("creat_user <=", value, "creatUser");
            return (Criteria) this;
        }

        public Criteria andCreatUserLike(String value) {
            addCriterion("creat_user like", value, "creatUser");
            return (Criteria) this;
        }

        public Criteria andCreatUserNotLike(String value) {
            addCriterion("creat_user not like", value, "creatUser");
            return (Criteria) this;
        }

        public Criteria andCreatUserIn(List<String> values) {
            addCriterion("creat_user in", values, "creatUser");
            return (Criteria) this;
        }

        public Criteria andCreatUserNotIn(List<String> values) {
            addCriterion("creat_user not in", values, "creatUser");
            return (Criteria) this;
        }

        public Criteria andCreatUserBetween(String value1, String value2) {
            addCriterion("creat_user between", value1, value2, "creatUser");
            return (Criteria) this;
        }

        public Criteria andCreatUserNotBetween(String value1, String value2) {
            addCriterion("creat_user not between", value1, value2, "creatUser");
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

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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