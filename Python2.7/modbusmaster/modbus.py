from pymodbus.client.sync import ModbusTcpClient
import time

client = ModbusTcpClient('10.1.51.254')
# client.write_coil(1, True)
#client.read_holding_registers(2, 1)

# while True:
result = client.write_registers(3, int(22), unit=24)
  # time.sleep(1)
# print result

# while True :
#   result = client.read_holding_registers(2, 1, unit=24)
#   print result.registers[0]
#   time.sleep(1)

client.close()

