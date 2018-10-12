package Filetest;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.permission.FsAction;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;
import org.apache.hadoop.io.IOUtils;

import java.io.*;

/**
 * ////////////////////////////////////////////////////////////////////
 * //                            _ooOoo_                               //
 * //                           o8888888o                              //
 * //                          88" . "88                              //
 * //                         (| ^_^ |)                              //
 * //                         O\  =  /O                              //
 * //                      ____/`---'\____                           //
 * //                    .'  \\|     |//  `.                         //
 * //                   /  \\|||  :  |||//  \                        //
 * //                  /  _||||| -:- |||||-  \                       //
 * //                  |   | \\\  -  /// |   |                       //
 * //                  | \_|  ''\---/''  |   |                       //
 * //                  \  .-\__  `-`  ___/-. /                       //
 * //                ___`. .'  /--.--\  `. . ___                     //
 * //              ."" '<  `.___\_<|>_/___.'  >'"".                  //
 * //            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
 * //            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
 * //      ========`-.____`-.___\_____/___.-`____.-'========         //
 * //                           `=---='                              //
 * //      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
 * //         佛祖保佑    			再无Bug				              //
 * ////////////////////////////////////////////////////////////////////
 * User:Diangan
 * Date:2018/9/17
 */

public class filetest {

    public static void main(String[] args) throws Exception {

        //checkFile();
        //getFileLocation();
        //Catalog();
        //look();
        //download();
        //upload();
        //delete();
        //suploadWithStream();
        //listFilestest();
        UpdatePermission();
    }

    public static void createFile() throws Exception {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        byte[] buff = "hello hadoop world! I am lijie\n".getBytes();
        Path dfs = new Path("/test.txt");
        FSDataOutputStream outputStream = hdfs.create(dfs);
        outputStream.write(buff, 0, buff.length);
        hdfs.close();
    }

    public static void createDir() throws Exception {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        Path dfs = new Path("/TestDir");
        hdfs.mkdirs(dfs);
        hdfs.close();
    }

    public static void rename() throws Exception {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        Path frpaht = new Path("/test.txt");    //旧的文件名
        Path topath = new Path("/testrename.txt");    //新的文件名
        boolean isRename = hdfs.rename(frpaht, topath);
        String result = isRename ? "成功" : "失败";
        System.out.println("文件重命名结果为：" + result);
        hdfs.close();
    }

    /**
    * 检索文件是否存在
    */
    public static void checkFile() throws Exception {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        Path findf = new Path("/test1.txt");
        boolean isExists = hdfs.exists(findf);
        if (isExists) {
            System.out.println("文件" + findf + "存在");
        } else {
            System.out.println("文件" + findf + "不存在");
        }
        hdfs.close();
    }

    public static void getModifyTime() throws Exception {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        Path fpath = new Path("/test1.txt");
        FileStatus fileStatus = hdfs.getFileStatus(fpath);
        long modiTime = fileStatus.getModificationTime();
        System.out.println("test.txt的修改时间是" + modiTime);
        hdfs.close();
    }

    /**
     * 通过"FileSystem.getFileBlockLocation（FileStatus file，long start，long len）
     * 可查找指定文件在HDFS集群上的位置，其中file为文件的完整路径，start和len来标识查找文件的路径。具体实现如下
     */
    public static void getFileLocation() throws Exception {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        Path fpath = new Path("/test1.txt");
        FileStatus filestatus = hdfs.getFileStatus(fpath);
        BlockLocation[] blkLocations = hdfs.getFileBlockLocations(filestatus, 0, filestatus.getLen());
        int blockLen = blkLocations.length;
        for (int i = 0; i < blockLen; i++) {
            String[] hosts = blkLocations[i].getHosts();
            System.out.println("block_" + i + "_location:" + hosts[0]);
        }
        hdfs.close();
    }

    /**
     * 通过"DatanodeInfo.getHostName（）"可获取HDFS集群上的所有节点名称
     */
    public static void getList() throws Exception {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        DistributedFileSystem hdfs = (DistributedFileSystem) fs;
        DatanodeInfo[] dataNodeStats = hdfs.getDataNodeStats();
        for (int i = 0; i < dataNodeStats.length; i++) {
            System.out.println("DataNode_" + i + "_Name:" + dataNodeStats[i].getHostName());
        }
        hdfs.close();
    }

    public static void listFilestest() throws Exception {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        FileStatus[] fileStatuses = hdfs.listStatus(new Path("/"));
        for (FileStatus fileStatus : fileStatuses) {
            System.out.println("这是一个：" + (fileStatus.isDirectory() ? "文件夹" : "文件"));
            System.out.println("副本系数：" + fileStatus.getReplication());
            System.out.println("大小：" + fileStatus.getLen());
            System.out.println("路径：" + fileStatus.getPath() + "\n");
        }
        hdfs.close();
    }

    /**
     * 列出指定目录的文件列表
     */
    public static void Catalog() throws Exception {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        Path findf = new Path("/");
        FileStatus fileStatus = hdfs.getFileStatus(findf);
        System.out.println("*************************************");
        System.out.println("文件根目录: " + fileStatus.getPath());
        System.out.println("这文件目录为：");
        for (FileStatus fs : hdfs.listStatus(findf)) {
            System.out.println(fs.getPath());
        }
        hdfs.close();
    }
    /**
     * 查看文件内容
     */
    public static  void look() throws Exception{
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        Path findf = new Path("/test1.txt");
        FSDataInputStream fsDataInputStream = hdfs.open(findf);
        System.out.println("*************************************");
        System.out.println("浏览文件：");
        int c;
        while((c = fsDataInputStream.read()) != -1){
            System.out.print((char)c);
        }
        fsDataInputStream.close();
        hdfs.close();
    }
    /**
     * 下载HDFS文件至本地指定目录
     */
    public static void download() throws Exception{
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        Path findf = new Path("/test1.txt");
        InputStream in = hdfs.open(findf);
        OutputStream out = new FileOutputStream("D://myfile/Node/dianganfile/src/main/test1.txt");
        IOUtils.copyBytes(in, out, 4096, true);
        hdfs.close();
    }

    /**
     * 上传文件至HDFS指定目录
     */
    public static void upload() throws Exception{
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        Path srcPath = new Path("D://myfile/Node/dianganfile/src/main/lijie.txt");
        Path dstPath = new Path("/TestDir/lijie.txt");
        hdfs.copyFromLocalFile(false, srcPath, dstPath);
        hdfs.close();
        System.out.println("*************************************");
        System.out.println("上传成功！");
        hdfs.close();
    }
    /**
    * 删除指定HDFS文件
    */
    public static void delete() throws Exception{
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        Path path = new Path("hdfs://192.168.16.129:9000/testrename.txt");
        boolean isExists = hdfs.exists(path);
        //底层参数 ：true 代表递归删除
        hdfs.delete(path,true);
        System.out.println("*************************************");
        System.out.println("删除成功！");
        hdfs.close();
    }

    public void listFiles() throws IOException {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        String dirName = "/test1";
        Path f = new Path(dirName);
        FileStatus[] status = hdfs.listStatus(f);
        System.out.println(dirName + " has all files:");
        if (status.length == 0) {
            System.out.println("nothing !");
        } else {
            for (int i = 0; i < status.length; i++) {
                System.out.println(status[i].getPath().toString());
            }
        }
        hdfs.close();
    }

    /**
     * 重写文件
     * @throws IOException
     */
    public static void uploadWithStream() throws IOException {
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        Path topath = new Path("/test1.txt");
        String frompath = "D://myfile/Node/dianganfile/src/main/lijie.txt";
        //HDFS上的文件流
        FSDataOutputStream outputStream = hdfs.create(topath, true);
        //本地读取的文件流
        FileInputStream inputStream = new FileInputStream(frompath);
        //将输入文件流写到输出文件流
        IOUtils.copyBytes(inputStream,outputStream,4096,false);
        hdfs.close();
    }

    /**
     * 更改文件权限
     * @throws IOException
     */
    public  static void UpdatePermission ()throws IOException{
        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        Path findf = new Path("/TestDir/lijie.txt");
      //  FsPermission permission = new FsPermission(FsAction.ALL,FsAction.ALL,FsAction.ALL)
        if(hdfs.exists(findf)){
            hdfs.setPermission(findf,new FsPermission(FsAction.ALL,FsAction.ALL,FsAction.ALL));
            System.out.println("更改成功");
        }
        else{
            System.out.println("文件不存在");
        }
    }
}