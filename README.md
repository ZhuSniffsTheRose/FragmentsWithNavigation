# FragmentsWithNavigation
use navigation(jetpack-component ) to switch Fragments

### Safe Args 

为 Navigation 组件中的 Gradle 插件，该插件可以生成简单的 object 和 builder 类，可以类型安全的方式浏览和访问任何关联的参数。所以本项目使用了 Safe Args 用于Navigation的数据传递，从而确保类型安全。

> 在 navigation Xml 中需要确认以下信息是否完整,否则 Safe Args 将不能完成类生成
> 1. <argument/> 标签已添加 至 目标 Fragment(本项目中为 SecondFragment)
> 2. 必须为根 <navigation> 元素提供一个 android:id 值
