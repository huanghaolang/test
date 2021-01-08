package com.ac;

import com.ac.dao.ItemmasterMultiselectMapper;
import com.ac.dao.SDsFieldsMapper;
import com.ac.dao.TPersonMapper;
import com.ac.dao.TVueAuthMapper;
import com.ac.entity.TPerson;
import com.ac.entity.TRole;
import com.ac.entity.TVueAuth;
import com.ac.ext.dao.ItemmasterExtMapper;
import com.ac.ext.entity.ItemmasterExt;
import com.ac.ext.entity.Meta;
import com.ac.ext.entity.Router;
import com.ac.service.ITPersonService;
import com.ac.service.ITRoleService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional(rollbackFor = Exception.class)
public class MybatisPlus {


    @Resource
    private TPersonMapper tPersonMapper;

    @Resource
    private ITPersonService itPersonService;

    @Resource
    private ITRoleService itRoleService;

    @Resource
    private TVueAuthMapper vueAuthMapper;


    @Resource
    private SDsFieldsMapper sDsFieldsMapper;

/*    @Resource
    private ItemmasterMultiselectMapper itemmasterMultiselectMapper;*/


@Test
public void getFileds(){

    System.out.println(JSON.toJSONString( sDsFieldsMapper.selectList(null)));
}
    @Resource
    private ItemmasterExtMapper itemmasterExtMapper;

    @Test
    public void itemmasterExt(){

        List<ItemmasterExt> list =  itemmasterExtMapper.getTableColumnById("T1");
        System.out.println(list);
    }


    @Test
    public void authTree() {



       /* QueryWrapper<TVueAuth> queryWrapper = new QueryWrapper<TVueAuth>();
        vueAuthMapper.selectList(queryWrapper);
        for(TVueAuth vueAuth : vueAuthMapper.selectList(queryWrapper)){
            System.out.println(vueAuth.getAuthUuid());
        }*/
        //
        List<Router> routerList = new ArrayList<>();
        Router router = null;
        Meta meta = null;
        for (TVueAuth vueAuth : vueAuthMapper.getRouters(null)) {
            router = new Router();
            meta = new Meta();
            meta.setTitle(vueAuth.getMetaTitle());
            meta.setIcon(vueAuth.getMetaIcon());
            router.setPath(vueAuth.getAuthPath());
            router.setName(vueAuth.getAuthName());
            router.setComponent(vueAuth.getAuthComponent());
            router.setRedirect(vueAuth.getAuthRedirect());
            router.setId(vueAuth.getAuthUuid());
            router.setParentId(vueAuth.getParentAuthUuid());
            router.setMeta(meta);
            routerList.add(router);
        }
        routerList = listToTree(routerList, "root");

        String jsonString = JSON.toJSONString(routerList.get(0).getChildren());
        List<Router> routers = routerList.get(0).getChildren();
        System.out.println(jsonString);
    }

    public static List<Router> listToTree(List<Router> list, String beginId) {
        // 用递归找子。

        List<Router> treeList = new ArrayList<Router>();
        for (Router tree : list) {
            if (tree.getId().equals(beginId)) {


                treeList.add(findChildren(tree, list));
            }
        }
        return treeList;
    }

    private static Router findChildren(Router tree, List<Router> list) {
        for (Router node : list) {
            if (!node.getId().equals(tree.getId()) &&
                    node.getParentId() != null &&
                    node.getParentId().equals(tree.getId())) {
                if (tree.getChildren() == null) {
                    tree.setChildren(new ArrayList<Router>());
                }
                tree.getChildren().add(findChildren(node, list));
            }
        }
        return tree;
    }

    @Test
    public void roleTest() {
        TRole tRole = new TRole();
        tRole.setRoleId("7");
        tRole.setRoleName("管理员22");
        tRole.setExplain("权限第一");
        // itRoleService.save(tRole);
        //  itRoleService.save(tRole);
        //itRoleService.saveOrUpdate(tRole);
        Collection<TRole> entityList = new ArrayList<>();
        entityList.add(tRole);
        itRoleService.saveBatch(entityList);
        /* for (TRole t: itRoleService.getRoleList(tRole)){
            System.out.println(t.getRoleName());
        }*/
    }

    @Test
    public void test() {
        System.out.println("----- baseMapper 自带分页 ------");
        Page<TPerson> page = new Page<>(1, 5);
        IPage<TPerson> userIPage = tPersonMapper.selectPage(page, new QueryWrapper<TPerson>()
                .like("name", "黄").orderByAsc("name", "emplid"));
        assertThat(page).isSameAs(userIPage);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        print(userIPage.getRecords());
        System.out.println("----- baseMapper 自带分页 ------");

    }

    @Test
    public void test2() throws Exception {
        itPersonService.savePerson();
    }


    private <T> void print(List<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(System.out::println);
        }
    }
}
