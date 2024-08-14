package me.qin.music.entity;

import java.util.ArrayList;
import java.util.List;

public class SongExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SongExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

        public Criteria andSongIdIsNull() {
            addCriterion("song_id is null");
            return (Criteria) this;
        }

        public Criteria andSongIdIsNotNull() {
            addCriterion("song_id is not null");
            return (Criteria) this;
        }

        public Criteria andSongIdEqualTo(Integer value) {
            addCriterion("song_id =", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdNotEqualTo(Integer value) {
            addCriterion("song_id <>", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdGreaterThan(Integer value) {
            addCriterion("song_id >", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("song_id >=", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdLessThan(Integer value) {
            addCriterion("song_id <", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdLessThanOrEqualTo(Integer value) {
            addCriterion("song_id <=", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdIn(List<Integer> values) {
            addCriterion("song_id in", values, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdNotIn(List<Integer> values) {
            addCriterion("song_id not in", values, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdBetween(Integer value1, Integer value2) {
            addCriterion("song_id between", value1, value2, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdNotBetween(Integer value1, Integer value2) {
            addCriterion("song_id not between", value1, value2, "songId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIsNull() {
            addCriterion("album_name is null");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIsNotNull() {
            addCriterion("album_name is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumNameEqualTo(String value) {
            addCriterion("album_name =", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotEqualTo(String value) {
            addCriterion("album_name <>", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameGreaterThan(String value) {
            addCriterion("album_name >", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameGreaterThanOrEqualTo(String value) {
            addCriterion("album_name >=", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLessThan(String value) {
            addCriterion("album_name <", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLessThanOrEqualTo(String value) {
            addCriterion("album_name <=", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLike(String value) {
            addCriterion("album_name like", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotLike(String value) {
            addCriterion("album_name not like", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIn(List<String> values) {
            addCriterion("album_name in", values, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotIn(List<String> values) {
            addCriterion("album_name not in", values, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameBetween(String value1, String value2) {
            addCriterion("album_name between", value1, value2, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotBetween(String value1, String value2) {
            addCriterion("album_name not between", value1, value2, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlIsNull() {
            addCriterion("albumcover_url is null");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlIsNotNull() {
            addCriterion("albumcover_url is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlEqualTo(String value) {
            addCriterion("albumcover_url =", value, "albumcoverUrl");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlNotEqualTo(String value) {
            addCriterion("albumcover_url <>", value, "albumcoverUrl");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlGreaterThan(String value) {
            addCriterion("albumcover_url >", value, "albumcoverUrl");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlGreaterThanOrEqualTo(String value) {
            addCriterion("albumcover_url >=", value, "albumcoverUrl");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlLessThan(String value) {
            addCriterion("albumcover_url <", value, "albumcoverUrl");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlLessThanOrEqualTo(String value) {
            addCriterion("albumcover_url <=", value, "albumcoverUrl");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlLike(String value) {
            addCriterion("albumcover_url like", value, "albumcoverUrl");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlNotLike(String value) {
            addCriterion("albumcover_url not like", value, "albumcoverUrl");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlIn(List<String> values) {
            addCriterion("albumcover_url in", values, "albumcoverUrl");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlNotIn(List<String> values) {
            addCriterion("albumcover_url not in", values, "albumcoverUrl");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlBetween(String value1, String value2) {
            addCriterion("albumcover_url between", value1, value2, "albumcoverUrl");
            return (Criteria) this;
        }

        public Criteria andAlbumcoverUrlNotBetween(String value1, String value2) {
            addCriterion("albumcover_url not between", value1, value2, "albumcoverUrl");
            return (Criteria) this;
        }

        public Criteria andLyricUrlIsNull() {
            addCriterion("lyric_url is null");
            return (Criteria) this;
        }

        public Criteria andLyricUrlIsNotNull() {
            addCriterion("lyric_url is not null");
            return (Criteria) this;
        }

        public Criteria andLyricUrlEqualTo(String value) {
            addCriterion("lyric_url =", value, "lyricUrl");
            return (Criteria) this;
        }

        public Criteria andLyricUrlNotEqualTo(String value) {
            addCriterion("lyric_url <>", value, "lyricUrl");
            return (Criteria) this;
        }

        public Criteria andLyricUrlGreaterThan(String value) {
            addCriterion("lyric_url >", value, "lyricUrl");
            return (Criteria) this;
        }

        public Criteria andLyricUrlGreaterThanOrEqualTo(String value) {
            addCriterion("lyric_url >=", value, "lyricUrl");
            return (Criteria) this;
        }

        public Criteria andLyricUrlLessThan(String value) {
            addCriterion("lyric_url <", value, "lyricUrl");
            return (Criteria) this;
        }

        public Criteria andLyricUrlLessThanOrEqualTo(String value) {
            addCriterion("lyric_url <=", value, "lyricUrl");
            return (Criteria) this;
        }

        public Criteria andLyricUrlLike(String value) {
            addCriterion("lyric_url like", value, "lyricUrl");
            return (Criteria) this;
        }

        public Criteria andLyricUrlNotLike(String value) {
            addCriterion("lyric_url not like", value, "lyricUrl");
            return (Criteria) this;
        }

        public Criteria andLyricUrlIn(List<String> values) {
            addCriterion("lyric_url in", values, "lyricUrl");
            return (Criteria) this;
        }

        public Criteria andLyricUrlNotIn(List<String> values) {
            addCriterion("lyric_url not in", values, "lyricUrl");
            return (Criteria) this;
        }

        public Criteria andLyricUrlBetween(String value1, String value2) {
            addCriterion("lyric_url between", value1, value2, "lyricUrl");
            return (Criteria) this;
        }

        public Criteria andLyricUrlNotBetween(String value1, String value2) {
            addCriterion("lyric_url not between", value1, value2, "lyricUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNull() {
            addCriterion("file_url is null");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNotNull() {
            addCriterion("file_url is not null");
            return (Criteria) this;
        }

        public Criteria andFileUrlEqualTo(String value) {
            addCriterion("file_url =", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotEqualTo(String value) {
            addCriterion("file_url <>", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThan(String value) {
            addCriterion("file_url >", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("file_url >=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThan(String value) {
            addCriterion("file_url <", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThanOrEqualTo(String value) {
            addCriterion("file_url <=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLike(String value) {
            addCriterion("file_url like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotLike(String value) {
            addCriterion("file_url not like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlIn(List<String> values) {
            addCriterion("file_url in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotIn(List<String> values) {
            addCriterion("file_url not in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlBetween(String value1, String value2) {
            addCriterion("file_url between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotBetween(String value1, String value2) {
            addCriterion("file_url not between", value1, value2, "fileUrl");
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
    }
}