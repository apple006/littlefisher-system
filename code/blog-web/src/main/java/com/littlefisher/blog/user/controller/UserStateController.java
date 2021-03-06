package com.littlefisher.blog.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.littlefisher.blog.user.model.UserStateDto;
import com.littlefisher.blog.user.service.IUserStateService;
import com.littlefisher.core.exception.BaseAppException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Description: 用户状态Controller
 * 
 * Created on 2017年5月17日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RestController
@RequestMapping("/api/blog/v1/user/userStates")
@Api(value = "userStates", description = "userStates 接口API")
public class UserStateController {
    
    /**
     * userStateService
     */
    @Autowired
    private IUserStateService userStateService;
    
    /**
     * 
     * Description: 查询所有用户状态
     * 
     * @author jinyanan
     *
     * @return List<UserStateDto>
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation("查询所有用户状态")
    public List<UserStateDto> getAllUserState() throws BaseAppException {
        return userStateService.getAllUserState();
    }
    
    /**
     * 
     * Description: 新增用户状态
     * 
     * @author jinyanan
     *
     * @param userStateDto userStateDto
     * @return UserStateDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.POST)
    public UserStateDto addUserState(
        @ApiParam(required = true, value = "用户状态实体") @RequestBody UserStateDto userStateDto) throws BaseAppException {
        return userStateService.addUserState(userStateDto);
    }

    /**
     * 
     * Description: 修改用户状态
     * 
     * @author jinyanan
     *
     * @param userStateDto userStateDto
     * @return UserStateDto
     * @throws BaseAppException <br>
     */
    @RequestMapping(method = RequestMethod.PATCH)
    @ApiOperation("修改用户状态")
    public UserStateDto updateUserState(
        @ApiParam(required = true, value = "用户状态实体") @RequestBody UserStateDto userStateDto) throws BaseAppException {
        return userStateService.updateUserState(userStateDto);
    }
    
    /**
     * 
     * Description: 删除用户状态
     * 
     * @author jinyanan
     *
     * @param state state
     * @return int
     * @throws BaseAppException <br>
     */
    @RequestMapping(value = "/{state}", method = RequestMethod.DELETE)
    @ApiOperation("删除用户状态")
    public int deleteUserState(
        @ApiParam(required = true, value = "状态") @PathVariable("state") String state) throws BaseAppException {
        return userStateService.deleteUserState(state);
    }
}
