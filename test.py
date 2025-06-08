import matplotlib.pyplot as plt

# 数据
years = [2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024]
approved_visas = [29270, 32648, 38728,
                  41895, 35330, 43732, 46821, 62079, 74466]

# 设置中文字体
plt.rcParams['font.sans-serif'] = ['SimHei']  # 设置支持中文的字体
plt.rcParams['axes.unicode_minus'] = False    # 正常显示负号

# 绘图
plt.figure(figsize=(12, 6))
bars = plt.bar(years, approved_visas, color='lightseagreen')

# 添加文字标签
for bar in bars:
    height = bar.get_height()
    plt.text(bar.get_x() + bar.get_width()/2, height + 1000,
             f'{height}', ha='center', va='bottom', fontsize=10)

# 添加标题和标签
plt.title('历年获批准的学生签证/进入许可申请人数', fontsize=14)
plt.xlabel('年份')
plt.ylabel('获批准的学生签证/进入许可申请人数')
plt.xticks(years)
plt.ylim(0, max(approved_visas) + 10000)
plt.grid(axis='y', linestyle='--', alpha=0.7)

plt.tight_layout()
plt.show()
