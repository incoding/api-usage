  -- foreach
  <select id="queryMemberAssistFeedback" resultMap="BaseResultWithMemberAssistTypeMap" 
    	parameterType="map">
    	select * from(select r.*,rownum rn from(
	    	 select 
	    	 <include refid="All_Column_List_Join"/>,<include refid="Member_Assist_Type_Column"/>,rownum
	    	 from member_assist_feedback f inner join  member_assist_type  t on type_id=t.id
	    	 where f.is_del=0
	    	 <if test="account!=null and account!=''">
	    	 	and f.account like '%'||#{account}||'%'
	    	 </if>
	    	 <if test="userName!=null">
	    	 	and f.user_name =#{userName}
	    	 </if>
	    	 <if test="startTime!=null">
	    	 	and f.create_time >= to_date(#{startTime},'yyyy-MM-dd hh24:mi:ss')
	    	 </if>
	    	 <if test="endTime!=null">
	    	 	and f.create_time <![CDATA[ < ]]> to_date(#{endTime},'yyyy-MM-dd hh24:mi:ss')
	    	 </if>
	    	 <if test="replyStatus!=null">
	    	 	and f.reply_status=#{replyStatus}
	    	 </if>
	    	 <if test="type!=null">
	    	 	and t.type=#{type}
	    	 </if>
	    	 <if test="auditStatusList!=null" >
	    	 	and f.audit_status in 
	    	 	<foreach collection="auditStatusList" item="auditStatus" open="(" close=")" separator=",">
	    	 		#{auditStatus}
	    	 	</foreach>
	    	 </if>
	    	 <if test="ids!=null">
	    	 	and t.id in 
	    	 	<foreach collection="ids" item="id" open="(" close=")" separator=",">
	    	 		#{id}
	    	 	 </foreach>
	    	 </if>
	    	 <if test="sellChannel!=null">
	    	 	and sell_channel=#{sellChannel}
	    	 </if>
	    	 <if test="adminType!=-1">
	    	 	and admin_type=#{adminType}
	    	 </if>
	    	 <if test="sellClientList!=null">
	    	 	and sell_client in 
	    	 	<foreach collection="sellClientList" item="sellClient" open="(" close=")" separator=",">
	    	 		#{sellClient}
	    	 	</foreach>
	    	 </if>
	    	 order by f.audit_status asc, f.create_time desc
	    	)r where <![CDATA[rownum <= #{endIndex}]]>
		) where rn>#{startIndex}
    </select>
    --
    <where>
				<if test="chargeWay!=null">
					mcc.charge_way=#{chargeWay}
				</if>
			</where>
			--  
				#{auditor,jdbcType=VARCHAR},
				---
	<select id="pageQueryAutoFollowFailData" parameterType="map" resultMap="autoFollowFailResultMap">
			select * from(
				select r.*,rownum rn from(
					select p.account  as launcher,
					       e.game_id  as gameId,
					       e.issue_no as issueNo,
					       e.plan_no  as planNo,
					       p.bet_type as betType,
					       p.play_type_desc as playTypeDesc,
					       p.select_type as selectType,
					       e.fail_info as failInfo,
					       e.create_time as createTime
					  from bet_auto_follow_errors e ,bet_plan p
					  <where>
					  		e.plan_no = p.plan_no
					  	<if test="followAccount!=null">
					  		and e.follow_account = #{followAccount}
					  	</if>
					  	<if test="gameId!=null">
					  		and  e.game_id = #{gameId}
					  	</if>
					  	<if test="startTime!=null">
							<![CDATA[and e.create_time >=to_date(#{startTime}, 'YYYY-MM-DD HH24:MI:SS')]]>
						</if>
						<if test="endTime!=null">
							<![CDATA[and e.create_time <=to_date(#{endTime}, 'YYYY-MM-DD HH24:MI:SS')]]>
						</if>
					  </where>
					order by e.create_time desc
				) r where <![CDATA[rownum <=#{endIndex}]]>
			) where rn > #{startIndex}
		</select>
		-----
			<select id="selectBetContentDisableForPage" parameterType="HashMap"
		resultMap="BetContentDisableMap">
		select * from (select r.*, rownum rn from (select
		<include refid="all_column_list" />
		from BET_CONTENT_DISABLE
		<where>
			<if test="gameID != null and gameID != -1">
				and GAME_ID = #{gameID}
			</if>
			<if test="parentGameID != null and parentGameID != -1">
				and PARENT_GAME_ID = #{parentGameID}
			</if>
			<if test="disableContent != null and disableContent!=''">
				and DISABLE_CONTENT like concat('%',
				concat(#{disableContent}, '%'))
			</if>
			<if test="playType != null and playType != -1">
				and PLAY_TYPE = #{playType}
			</if>
			<if test="disableType != null and disableType != -1">
				and DISABLE_TYPE = #{disableType}
			</if>
			<if test="beginTime != null and endTime != null">
				<![CDATA[ AND CREATE_TIME < #{endTime} + 1 and CREATE_TIME >= #{beginTime}]]>
			</if>
			<if test="status != null and status != -1">
				and STATUS = #{status}
			</if>
			<if test="createAccount != null and createAccount!=''">
				and CREATE_ACCOUNT like concat('%',
				concat(#{createAccount}, '%'))
			</if>
		</where>
		order by CREATE_TIME desc) r where <![CDATA[ rownum <= #{endIndex} ]]>)
		where <![CDATA[ rn > #{startIndex}]]>
	</select>
	------
	 	<select id="queryDcRacePage" parameterType="map" resultMap="baseResultMap">
 		select * from (
			select r.*,rownum rn from(			
		 	 select *   from bet_dc_race where is_del=0  and issue_no=#{issueNo}  
				<if test="status!=null">
				 and status=#{status}
				</if>
				<if test="wapCommend != null">
				 and wap_commend=#{wapCommend} 
				</if>
		 	  
		 	  order by match_no asc
 		 ) r 
 	   where <![CDATA[rownum <= #{endIndex}]]>
				) where rn>#{startIndex}
	</select>
	--------