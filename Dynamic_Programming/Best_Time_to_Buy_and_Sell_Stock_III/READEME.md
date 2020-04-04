every day, stockholder will have 4 status:
    
    1. has hold the 1st stock - hold1
    2. has sold the 1st stock - sold1
    3. has hold the 2nd stock - hold2
    4. has sold the 2nd stock - sold2


so when the kth day, the stockholder has 4 status:
	
	1. if the person maybe has bought the 1st stock: 
	the profit of hold1 = max(the current day he bought the stock, bought it before) --->  hold1[k] = max(0-prices[k], hold1[k-1])
	
	2. he maybe has sold the 1st stock:
	the profit of sold1 = max(the current day he sold the stock, sold it before) ---> sold1[k] = max( hold1[k-1]+ prices[k], sold1[k-1])

	3. he maybe has bought the 2nd stock:
	the profit of hold2 = max(the current day he bought the stock, bought it before) ---> hold2[k] = max(sold1[k-1] - prices[k], hold2[k-1])
	
	4. he maybe has sold the 2nd stock:
	the profit of sold2 = max(the current day he sold the stock, sold it before) ---> sold2[k] = max(hold2[k-1] + prices[k], sold2[k-1])


so the coding could be 

![](https://i.imgur.com/dP8v1v8.png)


then we need to consider the initial condition:

`hold1[0] = 0, sold1[0] = 0, hold2[0] = 0, sold2[0] = 0`  ???

No, because the 0th day, if the persong don't has a stock, it only has a status: `hold1[0] = 0 - prices[0] : bought the stock`
the same to hold2;  

so
`hold1[0] = -prices[0] , sold1[0] = 0, hold2[0] = MIN_VALUE, sold2[0] = 0`


