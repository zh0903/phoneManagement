package com.xm.manager.service.impl;

import cn.hutool.core.util.StrUtil;
import com.xm.common.utils.Constant;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xm.common.utils.PageUtils;
import com.xm.common.utils.Query;

import com.xm.manager.dao.LogDao;
import com.xm.manager.entity.LogEntity;
import com.xm.manager.service.LogService;


@Service("logService")
public class LogServiceImpl extends ServiceImpl<LogDao, LogEntity> implements LogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String startDate = (String)params.get(Constant.START);
        String endDate = (String)params.get(Constant.END);
        String laserNumer = (String)params.get(Constant.LASERNUMER);

        IPage<LogEntity> page = this.page(
                new Query<LogEntity>().getPage(params),
                new QueryWrapper<LogEntity>().apply(StrUtil.isNotBlank(startDate),
                            "date_format (create_time,'%Y-%m-%d') >= date_format('" + startDate + "','%Y-%m-%d')")
                        .apply(StrUtil.isNotBlank(endDate),
                            "date_format (create_time,'%Y-%m-%d') <= date_format('" + endDate + "','%Y-%m-%d')")
                        .apply(StrUtil.isNotBlank(laserNumer),"laser_numer='"+laserNumer+"'")
        );
        return new PageUtils(page);
    }
}