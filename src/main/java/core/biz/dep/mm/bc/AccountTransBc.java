package core.biz.dep.mm.bc;

import core.biz.dep.mm.vo.AccountTransCondVo;
import core.biz.dep.mm.vo.AccountTransHisVo;

public interface AccountTransBc {

	public AccountTransHisVo retrieveAccountTransHistory(AccountTransCondVo vo);
}
