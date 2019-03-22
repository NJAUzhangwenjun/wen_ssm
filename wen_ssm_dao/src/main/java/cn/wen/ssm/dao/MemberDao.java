package cn.wen.ssm.dao;

import org.apache.ibatis.annotations.*;
import cn.wen.ssm.domain.Member;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/2022:43
 */
public interface MemberDao {

		@Select("select * from member where id=#{id}")
		Member findById(String id) throws Exception;
}
