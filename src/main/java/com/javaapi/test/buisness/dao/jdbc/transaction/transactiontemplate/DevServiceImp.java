package com.javaapi.test.buisness.dao.jdbc.transaction.transactiontemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class DevServiceImp implements DevServiceI {

	@Autowired
	SnsUserDevDaoI	devDaoI;
	@Override
	public int update() {
		Integer result = transactionTemplate
				.execute(new TransactionCallback<Integer>() {
					@Override
					public Integer doInTransaction(TransactionStatus status) {
						// try{
						//
						// }catch(Exception e){
						// // 需要显示回滚
						// status.setRollbackOnly();
						// }
						// String bet007_id = "595959";
						// String sql =
						// "update matchs set league_name='斯伐乙西1'  where bet007_id="+bet007_id;
						int resultSns = snsDevDaoI.update();
						System.out.println(resultSns);

						int result = devDaoI.update();
						System.out.println(result);

						// 如果需要回滚,则 需要显示回滚
						boolean needRollBack = true;
						// 没什么特别之处,
						if (needRollBack) {
							status.setRollbackOnly();
							return 0;
						} else {
							return result;
						}

					}
				});
		return result;
	}
	@Autowired
	SnsMemberDevDaoI			snsDevDaoI;
	@Autowired
	TransactionTemplate	transactionTemplate;

}
