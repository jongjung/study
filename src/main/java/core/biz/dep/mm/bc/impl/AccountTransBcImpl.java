package core.biz.dep.mm.bc.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import core.biz.dep.mm.bc.AccountTransBc;
import core.biz.dep.mm.vo.AccountTransCondVo;
import core.biz.dep.mm.vo.AccountTransHisVo;
import core.fw.controller.BusinessController;

@Component("core.biz.dep.mm.AccountTransBcImpl")
public class AccountTransBcImpl implements AccountTransBc {

		private static final Logger logger = LoggerFactory.getLogger(AccountTransBcImpl.class);
	
	
		public AccountTransHisVo retrieveAccountTransHistory(AccountTransCondVo inputData){
			AccountTransHisVo result= new AccountTransHisVo();
			
			logger.debug("good");
			
			if("11111".equals(inputData.getCustomId()) && "1234-5678-22".equals(inputData.getAccountNo())){
			
				result.setCustomId("11111");
				result.setAccountNo("1234-5678-22");
				result.setTransDate("2022-05-01");
				
			}else {
				result.setCustomId("0000");
				result.setAccountNo("0000-0000-00");
				result.setTransDate("0000-00-00");
				
			}
				
			
			return result;
			
		}
}
