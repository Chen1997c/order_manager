<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <#include "/public/common/head.ftl" >
    <title>『点餐系统』菜品管理</title>
</head>

<body data-type="widgets">
<script src="${ctx}/js/theme.js"></script>

<div class="am-g tpl-g">
    <#include "/public/common/head-bar.ftl">
    <#include "/admin/common/side-bar.ftl">

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">
                                <ol class="am-breadcrumb breadcrumb-self">
                                    <li>
                                        <a href="#">首页</a>
                                    </li>
                                    <li class="am-active">
                                        菜品管理
                                    </li>
                                </ol>
                            </div>
                        </div>
                        <div class="widget-body  am-fr">

                            <div class="am-margin-bottom-lg am-cf">
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-5">
                                    <span>菜品列表</span>
                                </div>
                                <form id="search-user-form" class="am-u-sm-12 am-u-md-12 am-u-lg-4">
                                    <div class="am-form-group am-form-icon">
                                        <span class="am-icon-search"></span>
                                        <input type="text" name="d_name" class="am-form-field" placeholder="输入菜名搜索.."
                                               pattern="^\S{1,10}$">
                                    </div>
                                </form>
                                <div class="am-u-sm-12 am-u-md-12 am-u-lg-3 am-text-right">
                                    <button id="export" class="am-btn am-btn-sm am-btn-warning">
                                        导出Excel
                                    </button>
                                    <button id="add" class="am-btn am-btn-sm  am-btn-success"
                                            data-am-modal="{target: '#dish-add-modal', closeViaDimmer: 0, width: 600, height: 550}">
                                        添加菜品
                                    </button>
                                </div>
                            </div>

                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black "
                                       id="example-r">
                                    <thead>
                                    <tr>
                                        <th>菜品id</th>
                                        <th>菜品名称</th>
                                        <th>菜品价格</th>
                                        <th>查看</th>
                                        <th>编辑</th>
                                        <th>删除</th>
                                    </tr>
                                    </thead>
                                <tbody>
                                    <#list dishes.records as dish>
                                    <tr class="gradeX">
                                        <td id="id">${dish.d_id?c}</td>
                                        <td>${dish.d_name}</td>
                                        <td>${dish.d_price}</td>
                                        <input id="name" type="hidden" value="${dish.d_name}">
                                        <input id="price" type="hidden" value="${dish.d_price}">
                                        <input id="isGood" type="hidden" value="${dish.d_isGood}">
                                        <input id="description" type="hidden" value="${dish.d_description}">
                                        <input id="txt" type="hidden" value="${dish.d_txt}">
                                        <input id="img" type="hidden" value="${dish.d_img!}">
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a class="see-dInfo" href="javascript:;"
                                                   data-am-modal="{target: '#dish-info-modal'}">
                                                    <i class="am-icon-search"></i> 查看
                                                </a>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a class="edit-dInfo" href="javascript:;"
                                                   data-am-modal="{target: '#dish-edit-modal', closeViaDimmer: 0, width: 600, height: 550}">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;"
                                                   class="delete-dish tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <!-- more data -->
                                    </tbody>
                                    </#list>
                                </table>
                            </div>
                            <#if dishes.pages gt 1>
                             <div class="am-u-lg-12 am-cf">
                                 <div class="am-fr">
                                     <ul class="am-pagination tpl-pagination">
                                         <li class="am-disabled">
                                             <a href="#">总页数:${dishes.pages}</a>
                                         </li>
                                         <li class="am-disabled">
                                             <a href="#">当前页:${dishes.current}</a>
                                         </li>
                                         <li class="page-tag am-active">
                                             <a href="?current=1<#if d_name??>&d_name=${d_name}</#if>">首页</a>
                                         </li>
                                         <li class="page-tag am-active">
                                             <a href="?current=${dishes.current - 1}<#if d_name??>&d_name=${d_name}</#if>">上一页</a>
                                         </li>
                                         <li>
                                         <li class="page-tag am-active">
                                             <a href="?current=${dishes.current + 1}<#if d_name??>&d_name=${d_name}</#if>">下一页</a>
                                         </li>
                                         <li class="page-tag am-active">
                                             <a href="?current=${dishes.pages}<#if d_name??>&d_name=${d_name}</#if>">末页</a>
                                         </li>
                                     </ul>
                                 </div>
                             </div>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<#include "/admin/dish/info.ftl">
<#include "/admin/dish/edit.ftl">
<#include "/admin/dish/add.ftl">

<script src="${ctx}/js/amazeui.min.js"></script>
<script src="${ctx}/js/app.js"></script>
<script src="${ctx}/js/dish-edit.js"></script>
</body>

</html>