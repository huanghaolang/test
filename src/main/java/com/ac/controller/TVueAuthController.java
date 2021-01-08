package com.ac.controller;


import com.ac.dao.TVueAuthMapper;
import com.ac.entity.TVueAuth;
import com.ac.ext.entity.Meta;
import com.ac.ext.entity.Router;
import com.ac.jwtToken.TokenUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 1
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/vueAuth")
public class TVueAuthController {


    @Resource
    private TVueAuthMapper vueAuthMapper;


    @Resource
    private TokenUtil tokenUtil;

    @RequestMapping(value = "/getRoutersByToken",method = RequestMethod.POST)
    public List<Router> getRoutersByToken(String token,HttpServletResponse response, HttpServletRequest request){
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        // Map<String, Claim> claims = tokenUtil.verifyToken(token);
        //TODO 根据 token 找到该用户的权限
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
            // 0 默认 不隐藏 控制导航栏显示与否 1 隐藏路由
            router.setHidden(1==vueAuth.getAuthHidden());
            routerList.add(router);
        }
        routerList = listToTree(routerList, "root");

        String jsonString = JSON.toJSONString(routerList.get(0).getChildren());
        List<Router> routers = routerList.get(0).getChildren();
        System.out.println(jsonString);

        return routers;
    }


        @RequestMapping(value = "/getRouters",method = RequestMethod.POST)
        public List<Router> getRouters(HttpServletResponse response, HttpServletRequest request){
            response.setContentType("text/html;charset=utf-8");
            System.out.println(request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
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

            return routers;
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
}
