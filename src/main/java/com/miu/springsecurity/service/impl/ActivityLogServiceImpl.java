package com.miu.springsecurity.service.impl;

import com.miu.springsecurity.dto.ActivityLogDto;
import com.miu.springsecurity.entity.ActivityLog;
import com.miu.springsecurity.repository.ActivityLogRepo;
import com.miu.springsecurity.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ActivityLogServiceImpl implements ActivityLogService {
    private  final ActivityLogRepo activityLogRepo;
    private  final ModelMapper mapper;
    @Override
    public void save(ActivityLogDto activityLogDto) {
        activityLogRepo.save(mapper.map(activityLogDto, ActivityLog.class));
    }
}
