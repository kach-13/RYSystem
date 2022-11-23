package com.ry.pojo;

import java.util.Date;

public class SysRole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.role_id
     *
     * @mbg.generated
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.role_name
     *
     * @mbg.generated
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.role_key
     *
     * @mbg.generated
     */
    private String roleKey;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.role_sort
     *
     * @mbg.generated
     */
    private Integer roleSort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.data_scope
     *
     * @mbg.generated
     */
    private String dataScope;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.menu_check_strictly
     *
     * @mbg.generated
     */
    private Boolean menuCheckStrictly;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.dept_check_strictly
     *
     * @mbg.generated
     */
    private Boolean deptCheckStrictly;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.del_flag
     *
     * @mbg.generated
     */
    private String delFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.create_by
     *
     * @mbg.generated
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.update_by
     *
     * @mbg.generated
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated
     */
    public SysRole(Long roleId, String roleName, String roleKey, Integer roleSort, String dataScope, Boolean menuCheckStrictly, Boolean deptCheckStrictly, String status, String delFlag, String createBy, Date createTime, String updateBy, Date updateTime, String remark) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleKey = roleKey;
        this.roleSort = roleSort;
        this.dataScope = dataScope;
        this.menuCheckStrictly = menuCheckStrictly;
        this.deptCheckStrictly = deptCheckStrictly;
        this.status = status;
        this.delFlag = delFlag;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbg.generated
     */
    public SysRole() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.role_id
     *
     * @return the value of sys_role.role_id
     *
     * @mbg.generated
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.role_id
     *
     * @param roleId the value for sys_role.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.role_name
     *
     * @return the value of sys_role.role_name
     *
     * @mbg.generated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.role_name
     *
     * @param roleName the value for sys_role.role_name
     *
     * @mbg.generated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.role_key
     *
     * @return the value of sys_role.role_key
     *
     * @mbg.generated
     */
    public String getRoleKey() {
        return roleKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.role_key
     *
     * @param roleKey the value for sys_role.role_key
     *
     * @mbg.generated
     */
    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey == null ? null : roleKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.role_sort
     *
     * @return the value of sys_role.role_sort
     *
     * @mbg.generated
     */
    public Integer getRoleSort() {
        return roleSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.role_sort
     *
     * @param roleSort the value for sys_role.role_sort
     *
     * @mbg.generated
     */
    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.data_scope
     *
     * @return the value of sys_role.data_scope
     *
     * @mbg.generated
     */
    public String getDataScope() {
        return dataScope;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.data_scope
     *
     * @param dataScope the value for sys_role.data_scope
     *
     * @mbg.generated
     */
    public void setDataScope(String dataScope) {
        this.dataScope = dataScope == null ? null : dataScope.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.menu_check_strictly
     *
     * @return the value of sys_role.menu_check_strictly
     *
     * @mbg.generated
     */
    public Boolean getMenuCheckStrictly() {
        return menuCheckStrictly;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.menu_check_strictly
     *
     * @param menuCheckStrictly the value for sys_role.menu_check_strictly
     *
     * @mbg.generated
     */
    public void setMenuCheckStrictly(Boolean menuCheckStrictly) {
        this.menuCheckStrictly = menuCheckStrictly;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.dept_check_strictly
     *
     * @return the value of sys_role.dept_check_strictly
     *
     * @mbg.generated
     */
    public Boolean getDeptCheckStrictly() {
        return deptCheckStrictly;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.dept_check_strictly
     *
     * @param deptCheckStrictly the value for sys_role.dept_check_strictly
     *
     * @mbg.generated
     */
    public void setDeptCheckStrictly(Boolean deptCheckStrictly) {
        this.deptCheckStrictly = deptCheckStrictly;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.status
     *
     * @return the value of sys_role.status
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.status
     *
     * @param status the value for sys_role.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.del_flag
     *
     * @return the value of sys_role.del_flag
     *
     * @mbg.generated
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.del_flag
     *
     * @param delFlag the value for sys_role.del_flag
     *
     * @mbg.generated
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.create_by
     *
     * @return the value of sys_role.create_by
     *
     * @mbg.generated
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.create_by
     *
     * @param createBy the value for sys_role.create_by
     *
     * @mbg.generated
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.create_time
     *
     * @return the value of sys_role.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.create_time
     *
     * @param createTime the value for sys_role.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.update_by
     *
     * @return the value of sys_role.update_by
     *
     * @mbg.generated
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.update_by
     *
     * @param updateBy the value for sys_role.update_by
     *
     * @mbg.generated
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.update_time
     *
     * @return the value of sys_role.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.update_time
     *
     * @param updateTime the value for sys_role.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.remark
     *
     * @return the value of sys_role.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.remark
     *
     * @param remark the value for sys_role.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}