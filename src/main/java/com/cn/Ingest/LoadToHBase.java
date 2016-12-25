package com.cn.Ingest;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created by cloudera on 12/16/16.
 */
public class LoadToHBase {
    public LoadToHBase() throws Exception {
        Configuration conf =  HBaseConfiguration.create();
        HTable        table = new HTable(conf, "my-table-1718");
        Put put = new Put(Bytes.toBytes("row1"));
        put.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"), Bytes.toBytes("val1"));
        put.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual2"), Bytes.toBytes("val2"));
        put.add(Bytes.toBytes("colfam2"), Bytes.toBytes("qual1"), Bytes.toBytes("val3"));
        put.add(Bytes.toBytes("colfam2"), Bytes.toBytes("qual2"), Bytes.toBytes("val4"));
        //put.add

        table.put(put);
        table.flushCommits();
        table.close();

        int a = 7;
    }

    public static void main(String args[]) throws Exception {
        LoadToHBase lth = new LoadToHBase();
    }
}
