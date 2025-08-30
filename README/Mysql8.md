## mysql 5.7以后默认使用caching_sha2_password认证方式，如果认证模式是mysql_native_password，则需要修改为caching_sha2_password，否则无法登录
```mysql
ALTER USER 'username'@'host' IDENTIFIED WITH caching_sha2_password BY 'password';
```

ALTER USER 'root'@'localhost' IDENTIFIED BY 'new_password';
FLUSH PRIVILEGES;

grant all privileges on *.* to 'maxvision'@'%' with grant option;


在 Linux KAARDATA 系统（基于 aarch64 架构）上进行 MySQL 8 的离线安装，可以通过以下步骤完成。这些步骤结合了从 MySQL 官方下载安装包、手动解压和配置的过程。


步骤 1：准备离线安装包

• 在有网络的机器上下载 MySQL 安装包：

• 访问[MySQL 官方下载页面]()。

• 选择适合 Linux 的 MySQL 社区版（Community Server），并下载适用于 aarch64 架构的`.tar.xz`文件（例如`mysql-8.0.39-linux-glibc2.28-aarch64.tar.xz`）。

• 同时下载`mysql-community-client-plugins`和其他依赖的 RPM 包（如果需要）。


• 将下载的文件传输到目标服务器：

• 使用 USB 驱动器、SCP 或其他方式将下载的文件传输到目标服务器的某个目录，例如`/opt/mysql`。


步骤 2：安装依赖
在 Linux KAARDATA 系统上，可能需要安装一些依赖库。运行以下命令安装必要的依赖：

```bash
sudo apt update
sudo apt install -y libncurses5 libaio1
```



步骤 3：解压安装包

• 解压 MySQL 安装包：

```bash
   cd /opt/mysql
   tar -xvf mysql-8.0.39-linux-glibc2.28-aarch64.tar.xz
   mv mysql-8.0.39-linux-glibc2.28-aarch64 /usr/local/mysql
   ```



• 创建必要的目录：

```bash
   sudo mkdir -p /usr/local/mysql/data
   sudo mkdir -p /usr/local/mysql/logs
   sudo mkdir -p /usr/local/mysql/tmp
   ```



步骤 4：创建 MySQL 用户和组

• 创建 MySQL 用户和组：

```bash
   sudo groupadd mysql
   sudo useradd -r -g mysql -s /bin/false mysql
   ```



• 修改文件所有者：

```bash
   sudo chown -R mysql:mysql /usr/local/mysql
   ```



步骤 5：配置 MySQL

• 创建 MySQL 配置文件：

```bash
   sudo nano /etc/my.cnf
   ```

添加以下内容：

```ini
   [mysqld]
   basedir=/usr/local/mysql
   datadir=/usr/local/mysql/data
   socket=/tmp/mysql.sock
   user=mysql
   port=3306
   log-error=/usr/local/mysql/logs/mysql.log
   pid-file=/usr/local/mysql/mysql.pid
   character-set-server=utf8mb4
   collation-server=utf8mb4_general_ci

   [client]
   socket=/tmp/mysql.sock
   ```



步骤 6：初始化 MySQL 数据库

• 初始化 MySQL 数据库：

```bash
   cd /usr/local/mysql/bin
   sudo ./mysqld --initialize --user=mysql --basedir=/usr/local/mysql --datadir=/usr/local/mysql/data
   ```

初始化完成后，系统会生成一个临时密码，记录在日志文件中（例如`/usr/local/mysql/logs/mysql.log`）。找到并记录这个临时密码。


步骤 7：启动 MySQL 服务

• 将 MySQL 添加到系统服务：

```bash
   sudo cp /usr/local/mysql/support-files/mysql.server /etc/init.d/mysqld
   sudo chmod +x /etc/init.d/mysqld
   sudo systemctl daemon-reload
   sudo systemctl start mysqld
   sudo systemctl enable mysqld
   ```



• 检查服务状态：

```bash
   sudo systemctl status mysqld
   ```



步骤 8：登录 MySQL 并修改密码

• 登录 MySQL：

```bash
   mysql -u root -p
   ```

输入初始化时生成的临时密码。


• 修改 root 用户密码：

```sql
   ALTER USER 'root'@'localhost' IDENTIFIED BY 'new_password';
   FLUSH PRIVILEGES;
   exit;
   ```



步骤 9：配置远程访问（可选）
如果需要从其他机器访问 MySQL，可以执行以下操作：

• 授权远程访问：

```sql
   CREATE USER 'root'@'%' IDENTIFIED BY 'new_password';
   GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
   FLUSH PRIVILEGES;
   ```



• 修改配置文件以允许远程连接：
编辑`/etc/my.cnf`，在`[mysqld]`部分添加以下内容：

```ini
   bind-address=0.0.0.0
   ```



• 重启 MySQL 服务：

```bash
   sudo systemctl restart mysqld
   ```



步骤 10：验证安装

• 从其他机器测试连接：

```bash
   mysql -h your_server_ip -u root -p
   ```

输入密码后，如果能够成功连接，则表示 MySQL 服务已正确配置。


常见问题及解决方案

• 服务启动失败：

• 检查`/etc/my.cnf`文件路径和权限。

• 查看日志文件`/usr/local/mysql/logs/mysql.log`排查错误。


• 密码认证问题：

• 如果客户端连接报错`caching_sha2_password`，可以修改认证方式：

```sql
     ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'new_password';
     FLUSH PRIVILEGES;
     ```


通过以上步骤，你可以在 Linux KAARDATA 系统上成功离线安装并配置 MySQL 8。如果在操作过程中遇到问题，请根据错误信息进行排查，或提供更多详细信息以便进一步协助！
