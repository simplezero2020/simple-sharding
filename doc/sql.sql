CREATE TABLE `pick_task`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `warehouse_id`   bigint(20)          NOT NULL COMMENT '仓库ID',
    `warehouse_code` varchar(64)         NOT NULL DEFAULT '' COMMENT '仓库编码',
    `place_id`       bigint(20)          NOT NULL DEFAULT '0' COMMENT '目的流向ID',
    `place_code`     varchar(64)         NOT NULL DEFAULT '' COMMENT '目的流向编码',
    `item_id`        bigint(20)          NOT NULL COMMENT '销售商品ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='分拣任务';

CREATE TABLE `pick_task_0`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `warehouse_id`   bigint(20)          NOT NULL COMMENT '仓库ID',
    `warehouse_code` varchar(64)         NOT NULL DEFAULT '' COMMENT '仓库编码',
    `place_id`       bigint(20)          NOT NULL DEFAULT '0' COMMENT '目的流向ID',
    `place_code`     varchar(64)         NOT NULL DEFAULT '' COMMENT '目的流向编码',
    `item_id`        bigint(20)          NOT NULL COMMENT '销售商品ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='分拣任务';

CREATE TABLE `pick_task_1`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `warehouse_id`   bigint(20)          NOT NULL COMMENT '仓库ID',
    `warehouse_code` varchar(64)         NOT NULL DEFAULT '' COMMENT '仓库编码',
    `place_id`       bigint(20)          NOT NULL DEFAULT '0' COMMENT '目的流向ID',
    `place_code`     varchar(64)         NOT NULL DEFAULT '' COMMENT '目的流向编码',
    `item_id`        bigint(20)          NOT NULL COMMENT '销售商品ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='分拣任务';

CREATE TABLE `pick_task_2`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `warehouse_id`   bigint(20)          NOT NULL COMMENT '仓库ID',
    `warehouse_code` varchar(64)         NOT NULL DEFAULT '' COMMENT '仓库编码',
    `place_id`       bigint(20)          NOT NULL DEFAULT '0' COMMENT '目的流向ID',
    `place_code`     varchar(64)         NOT NULL DEFAULT '' COMMENT '目的流向编码',
    `item_id`        bigint(20)          NOT NULL COMMENT '销售商品ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='分拣任务';

CREATE TABLE `pick_task_3`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `warehouse_id`   bigint(20)          NOT NULL COMMENT '仓库ID',
    `warehouse_code` varchar(64)         NOT NULL DEFAULT '' COMMENT '仓库编码',
    `place_id`       bigint(20)          NOT NULL DEFAULT '0' COMMENT '目的流向ID',
    `place_code`     varchar(64)         NOT NULL DEFAULT '' COMMENT '目的流向编码',
    `item_id`        bigint(20)          NOT NULL COMMENT '销售商品ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='分拣任务';


CREATE TABLE `pick_task_4`
(
    `id`             bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `warehouse_id`   bigint(20)          NOT NULL COMMENT '仓库ID',
    `warehouse_code` varchar(64)         NOT NULL DEFAULT '' COMMENT '仓库编码',
    `place_id`       bigint(20)          NOT NULL DEFAULT '0' COMMENT '目的流向ID',
    `place_code`     varchar(64)         NOT NULL DEFAULT '' COMMENT '目的流向编码',
    `item_id`        bigint(20)          NOT NULL COMMENT '销售商品ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='分拣任务';


CREATE TABLE retry_biz_record
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    biz_no       varchar(100)        NOT NULL DEFAULT '' COMMENT '业务单据号',
    biz_id       bigint(20)                   DEFAULT NULL COMMENT '业务id',
    biz_type     int(11)             NOT NULL COMMENT '业务类型',
    sharding_key varchar(100)                 DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='重试记录表'
;


CREATE TABLE retry_biz_record_202201_0
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    biz_no       varchar(100)        NOT NULL DEFAULT '' COMMENT '业务单据号',
    biz_id       bigint(20)                   DEFAULT NULL COMMENT '业务id',
    biz_type     int(11)             NOT NULL COMMENT '业务类型',
    sharding_key varchar(100)                 DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='重试记录表'
;

CREATE TABLE retry_biz_record_202201_1
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    biz_no       varchar(100)        NOT NULL DEFAULT '' COMMENT '业务单据号',
    biz_id       bigint(20)                   DEFAULT NULL COMMENT '业务id',
    biz_type     int(11)             NOT NULL COMMENT '业务类型',
    sharding_key varchar(100)                 DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='重试记录表'
;

CREATE TABLE retry_biz_record_202202_0
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    biz_no       varchar(100)        NOT NULL DEFAULT '' COMMENT '业务单据号',
    biz_id       bigint(20)                   DEFAULT NULL COMMENT '业务id',
    biz_type     int(11)             NOT NULL COMMENT '业务类型',
    sharding_key varchar(100)                 DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='重试记录表'
;

CREATE TABLE retry_biz_record_202202_1
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    biz_no       varchar(100)        NOT NULL DEFAULT '' COMMENT '业务单据号',
    biz_id       bigint(20)                   DEFAULT NULL COMMENT '业务id',
    biz_type     int(11)             NOT NULL COMMENT '业务类型',
    sharding_key varchar(100)                 DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='重试记录表'
;

CREATE TABLE retry_biz_record_202202_2
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    biz_no       varchar(100)        NOT NULL DEFAULT '' COMMENT '业务单据号',
    biz_id       bigint(20)                   DEFAULT NULL COMMENT '业务id',
    biz_type     int(11)             NOT NULL COMMENT '业务类型',
    sharding_key varchar(100)                 DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='重试记录表'
;

CREATE TABLE retry_biz_record_202202_3
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    biz_no       varchar(100)        NOT NULL DEFAULT '' COMMENT '业务单据号',
    biz_id       bigint(20)                   DEFAULT NULL COMMENT '业务id',
    biz_type     int(11)             NOT NULL COMMENT '业务类型',
    sharding_key varchar(100)                 DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='重试记录表'
;

CREATE TABLE `operation_log`
(
    `id`                bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_phone`        varchar(64)         NOT NULL COMMENT '用户账号',
    `user_phone_suffix` varchar(16)         NOT NULL DEFAULT '' COMMENT '用户账号4位后缀',
    `user_name`         varchar(64)         NOT NULL COMMENT '用户名称',
    `create_time`       timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4 COMMENT = '操作日志';

CREATE TABLE `operation_log_202201`
(
    `id`                bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_phone`        varchar(64)         NOT NULL COMMENT '用户账号',
    `user_phone_suffix` varchar(16)         NOT NULL DEFAULT '' COMMENT '用户账号4位后缀',
    `user_name`         varchar(64)         NOT NULL COMMENT '用户名称',
    `create_time`       timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4 COMMENT = '操作日志';

CREATE TABLE `operation_log_202202`
(
    `id`                bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_phone`        varchar(64)         NOT NULL COMMENT '用户账号',
    `user_phone_suffix` varchar(16)         NOT NULL DEFAULT '' COMMENT '用户账号4位后缀',
    `user_name`         varchar(64)         NOT NULL COMMENT '用户名称',
    `create_time`       timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4 COMMENT = '操作日志';

CREATE TABLE `operation_log_202203`
(
    `id`                bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_phone`        varchar(64)         NOT NULL COMMENT '用户账号',
    `user_phone_suffix` varchar(16)         NOT NULL DEFAULT '' COMMENT '用户账号4位后缀',
    `user_name`         varchar(64)         NOT NULL COMMENT '用户名称',
    `create_time`       timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4 COMMENT = '操作日志';


CREATE TABLE `inv_inventory_log`
(
    `id`       bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `sku_id`   bigint(20)   NOT NULL COMMENT '商品表主键',
    `sku_code` varchar(64)  NOT NULL COMMENT '商品编码',
    `sku_name` varchar(250) NOT NULL COMMENT '商品名称',
    `place_id` bigint(20)   NOT NULL COMMENT '仓库表主键',
    `month`    varchar(16)  NOT NULL COMMENT '月份',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT = '库存日志表';


CREATE TABLE `inv_inventory_log_2021_10_1`
(
    `id`       bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `sku_id`   bigint(20)   NOT NULL COMMENT '商品表主键',
    `sku_code` varchar(64)  NOT NULL COMMENT '商品编码',
    `sku_name` varchar(250) NOT NULL COMMENT '商品名称',
    `place_id` bigint(20)   NOT NULL COMMENT '仓库表主键',
    `month`    varchar(16)  NOT NULL COMMENT '月份',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT = '库存日志表';

CREATE TABLE `inv_inventory_log_2021_10_127`
(
    `id`       bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `sku_id`   bigint(20)   NOT NULL COMMENT '商品表主键',
    `sku_code` varchar(64)  NOT NULL COMMENT '商品编码',
    `sku_name` varchar(250) NOT NULL COMMENT '商品名称',
    `place_id` bigint(20)   NOT NULL COMMENT '仓库表主键',
    `month`    varchar(16)  NOT NULL COMMENT '月份',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT = '库存日志表';