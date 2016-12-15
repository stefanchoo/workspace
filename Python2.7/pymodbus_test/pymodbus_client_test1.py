#!/usr/bin/env python
# -*- coding:utf-8 -*-

from pymodbus.client.sync import ModbusTcpClient

# ----------------------------------------------------- #
# 连 接
# ----------------------------------------------------- #
client = ModbusTcpClient('127.0.0.1', port=502)  # 连接， IP 和 端口（502）
client.connect()

# ----------------------------------------------------- #
# 读线圈，写线圈
# ----------------------------------------------------- #
'''
client.write_coil(8, True)
result = client.read_coils(0, 10, unit=0x02)
print result
for i in result.bits:
    print i
'''
# ----------------------------------------------------- #
# 读寄存器输入
# ----------------------------------------------------- #
'''
result = client.read_input_registers(10, 10, unit=0x03)
# type(result)
print type(result)
'''

result = client.read_holding_registers(0, 9, unit=0x01)
print result.registers[8]
client.close()
