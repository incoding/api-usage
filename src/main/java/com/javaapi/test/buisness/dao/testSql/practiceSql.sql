select * from sns_wall;

-- left join,right join
select * from sns_wall left  join sns_social on sns_wall.snsId=sns_social.Id;
select * from sns_wall right join sns_social on sns_wall.snsId=sns_social.Id;
select * from sns_wall inner join sns_social on sns_wall.snsId=sns_social.Id;

-- count
select count(1) from sns_social left join sns_wall on sns_wall.snsId=sns_social.id

-- limit
select * from sns_wall  limit 0,1;

-- order by
select * from sns_wall where sns_wall.sort =1 order by sns_wall.time desc;

-- group by
select sns_wall.sort ,count(1) from sns_wall
left join sns_social on sns_wall.snsId=sns_social.id 
group by sort;

-- between
select sns_wall.sort,count(1),sns_wall.time from sns_wall where sns_wall.time
between '2012-12-08' AND '2012-12-16' group by  sns_wall.sort ;

--in
select * from sns_wall where sns_wall.sort in (1,2);
--  not in 
 select 
	     recommend.recommendObjectId as other_id,
	     social.name as name,
         social.head as head,
         social.province as province,
         social.city as city 
	   from 
	     sns_social social,
	     sns_circle_recommend recommend 
	  where 
	     social.id=recommend.recommendObjectId and 
	     recommend.recommendObjectType='PERSON' and 
	     recommendState='Y' and (recommend.recommendObjectId 
	     not in (select friendId from mem_friend_auth where userId=#{id}))
	     and recommend.recommendObjectId!=#{id}
		order by recommend.starLevel DESC  limit ${currentPage},${pageSize}

-- distinct
select DISTINCT sns_wall.time from sns_wall;

--1.在count 不重复的记录的时候能用到,比如
SELECT COUNT( DISTINCT id ) FROM tablename;
--就是计算talbebname表中id不同的记录有多少条
--2,在需要返回记录不同的id的具体值的时候可以用,比如
SELECT DISTINCT id FROM tablename;
--返回talbebname表中不同的id的具体的值
--3.上面的情况2对于需要返回mysql表中2列以上的结果时会有歧义--比如
SELECT DISTINCT id, type FROM tablename;
--实际上返回的是 id与type同时不相同的结果,也就是DISTINCT同时作用了两个字段，必须得id与tyoe都相同的才被排除了,与我们期望的结果不一样
--4.这时候可以考虑使用group_concat函数来进行排除,不过这个mysql函数是在mysql4.1以上才支持的
--5.其实还有另外一种解决方式,就是使用--
SELECT id, type, count(DISTINCT id) FROM tablename
--虽然这样的返回结果多了一列无用的count数据(或许你就需要这个我说的无用数据)
--返回的结果是 只有id不同的所有结果和上面的4类型可以互补使用,就是看你需要什么样的数据了

--6.
--这样貌似也可以
--用distinct的时候，如果它有索引，mysql会把它转成group by的方式执行。



-- 嵌套sql
SELECT
		a.activityId,
		a.activityBeginDate,
		a.activityEndDate,
		a.activityTitle,
		a.activityDescription,
		a.activityCreatorId,
		a.activityObjectType,
		a.activityObjectId
		FROM sns_activity a
		LEFT JOIN
		(SELECT activityCreateTime AS CreateTime,activityId AS
		activityConfId
		FROM sns_activity_conf) c
		ON a.activityId=c.activityConfId
		WHERE
		a.activityObjectId=#{activityObjectId}
		ORDER BY c.CreateTime DESC
		LIMIT
		#{beginNum},#{pageSize}
--嵌套sql,括号内查询出来的内容没有索引
		   select
                h.circleId,h.circleName,h.circleType as CIRCLETYPE,f.activityCreateTime as ACTIVITYBEGINDATE,
                y.activityId,y.activityTitle,y.activityCreatorId,y.activityEndDate,
                d.recommendId,d.recommendTime,d.recommendState,d.recommendSort,d.recommendUserId,d.recommendPage,d.starLevel,
                l.name,
                (select count(1) from sns_circle_apply a1 where a1.applyState='PASS' and a1.circleId=y.activityObjectId) as activityCount, 
                (select count(1) from sns_comment a2 where a2.commentState='NORMAL' and a2.commentObjectId=y.activityId) as commentCount
               from sns_activity y left join sns_circle_recommend d on  d.recommendObjectId=y.activityId
                                   left join sns_circle_auth h on y.activityObjectId=h.circleId
                                   left join sns_social l on y.activityCreatorId=l.id
                                   left join sns_activity_conf f on f.activityId=y.activityId
               where  d.recommendObjectType='ACTIVITY'
               
               
 -- 动态sql
 <select id="countByProperties" parameterType="CircleApply" resultType="Integer">
		select count(*) from sns_circle_apply 
		
		where 1=1
		
		
		<if test="circleId!=null and circleId!=''">
			and circleId=#{circleId}
		</if>
		<if test="applyEventType!=null and applyEventType!=''">
			and applyEventType=#{applyEventType}
		</if>
		<if test="applyUserId!=null and applyUserId!=''">
			and applyUserId=#{applyUserId}
		</if>
		<if test="applyId!=null and applyId!=''">
			and applyId=#{applyId}
		</if>
		<if test="applyMemberId!=null and applyMemberId!=''">
			and applyMemberId=#{applyMemberId}
		</if>
		<if test="applyMemberType!=null and applyMemberType!=''">
			and applyMemberType=#{applyMemberType}
		</if>
		<if test="applyState!=null and applyState!=''">
			and applyState=#{applyState}
		</if>
	</select>
--    --------------------------------------------

-- 插入
INSERT INTO sns_card_favor(id,userId,favorId,favortype,groupId,createtime)
    VALUES(
    	#{id,javaType=java.util.UUID,jdbcType=VARCHAR},
    	#{userId},
    	#{favorId},
    	'Y',
    	'0',
    	SYSDATE())
		
--	更新
update	sns_comment set commentState='DELETE' where commentId=#{commentId};

-- 更新 范围
UPDATE
		sns_card_favor SET groupId='0' where
		userId = #{userId} and
		groupId in 
		<foreach item="idItem" collection="groupIds" open="(" separator="," close=")">
			#{idItem}
		</foreach>
-- 删除
     DELETE FROM sns_circle_favor WHERE userId=#{userId} AND objectId=#{marketId};
-- concat 拼字符串 
circleAuth.circleName LIKE CONCAT('%','some','%' );

--  where 1=1
--  IS NULL
 IS NULL;
--UUID()
UUID();
-- truncate
truncate ;
--curdate()
curdate();  

SYSDATE();

to_date(#{createTime},'yyyy-mm-dd hh24:mi:ss')
--


---
--准备
CREATE TABLE IF NOT EXISTS `tbl_b` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `val` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 ;

INSERT INTO tbl_b (val) VALUES ('a');
-------http://lq2419.blog.51cto.com/1365130/1226000
--然后console1,图形化mysql workbench中则是大tab
select @@autocommit; 
select @@tx_isolation;
 

set autocommit=0;
set tx_isolation='read-uncommitted';

start transaction;
update tbl_b set val='1' where val='a';
select * from tbl_b;
rollback;
-- console2 ,图形化mysql workbenche另一个大tab
select @@autocommit; 
select @@tx_isolation;
 

set autocommit=0;
set tx_isolation='read-uncommitted';

start transaction;
select * from tbl_b;