## window服务下配置NTP服务器
启用并配置Windows Time服务Windows系统内置了Windows Time服务（w32time），该服务可用于NTP时间同步。 

### 启动Windows Time服务
1. 按  Win+R  键，输入  services.msc  ，然后按  Enter  键。
2. 在服务列表中找到“Windows Time”服务，右键点击并选择“属性”。
3. 在“启动类型”中选择“自动”，然后点击“应用”和“确定”。
4. 如果服务未运行，点击“启动”按钮启动服务。

### 修改注册表以启用NTP服务器功能
1. 按  Win+R  键，输入  regedit  ，然后按  Enter  键打开注册表编辑器 
2. 导航到以下路径：
```
   HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\W32Time\TimeProviders\NtpServer
```
3. 在右侧窗格中找到  Enabled  ，双击它，将其值设置为  1  ，以启用NTP服务器功能。

### 配置时间源
1. 导航到以下路径：
```
   HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\W32Time\Parameters
```
2. 在右侧窗格中找到  NtpServer  ，双击它，输入你想要同步的时间服务器地址，例如  time.windows.com,0x1  。（10.131.72.100 为省NTP时钟服务器）
  如果要使用本地服务器作为时间源，可以输入  127.0.0.1,0x1  。

### 配置时间校准设置
1.导航到以下路径：
```
HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\W32Time\Config
```
2. 在右侧窗格中找到  AnnounceFlags  ，双击它，将其值设置为  5  ，表示强制主机将自身宣布为可靠的时间源。
### 重启Windows Time服务
1. 打开命令提示符（以管理员身份），输入以下命令并按  Enter  键：
```cmd
   net stop w32time
   net start w32time
   ```
#### 配置防火墙以允许NTP流量
1. 打开“控制面板”，选择“系统和安全”>“Windows Defender 防火墙”>“高级设置”。
2. 在“Windows Defender 防火墙与高级安全”窗口中，选择“入站规则”。
3. 点击“新建规则”。
4. 在“新建入站规则向导”中，选择“端口”，点击“下一步”。
5. 选择“UDP”，并输入端口号  123  ，点击“下一步”。
6. 选择“允许连接”，点击“下一步”。
7. 根据需要选择适用的配置文件（如域、私有、公共），点击“下一步”。
8. 输入规则名称（如“NTP”），并添加描述，点击“完成”。

### 测试NTP服务器
1. 本机测试：
• 打开命令提示符，输入以下命令并按  Enter  键：
```cmd
w32tm /stripchart /computer:127.0.0.1
```
• 如果看到时间回显，表示配置成功。
客户端测试：• 在另一台电脑上，打开命令提示符，输入以下命令并按  Enter  键：
```cmd
w32tm /config /manualpeerlist:"<服务器IP地址>" /syncfromflags:manual /update
```
• 然后输入以下命令强制同步时间：
```cmd 
w32tm /resync
```
• 如果时间同步成功，表示客户端可以正常从你的NTP服务器获取时间。


