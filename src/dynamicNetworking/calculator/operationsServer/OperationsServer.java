/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicNetworking.calculator.operationsServer;

/**
 *
 * @author steffen
 */
public class OperationsServer {
 
    public Object getOperation(String operationString)
    {
        if(operationString == "*" ||
           operationString == "/" ||
           operationString == "+" ||
           operationString == "-")
        {
            return operationString;
        }
        else
        {
            System.out.println("not an operation");
            return null;
        }
    }
}