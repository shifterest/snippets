#include <iostream>
#include <iomanip>
using namespace std;

const double RES_PROC = 4.5,            // Residential processing fee
             RES_SRVC = 30,             // Residential basic service fee
             RES_CHNL = 5,              // Residential fee per premium channel
             BUS_PROC = 16.5,           // Business processing fee
             BUS_SRVC_UNDER_5 = 80,     // Business basic service fee under 5 connections
             BUS_SRVC_OVER_5 = 4,       // Business basic service fee per connection over 5 connections
             BUS_CHNL = 50;             // Business fee per premium channel
    
int main()
{
    int choice;
    double processingFee, serviceFee, channelFee, cableBill;
    
    cout << "CABLE BILL CALCULATOR" << endl << endl;
    cout << "Enter customer type (1 for residential, 2 for business): ";
    
    // Repeatedly ask customer type if input is wrong 
    do {
        cin >> choice;
        if (choice != 1 && choice != 2)
            cout << "Invalid choice. Try again: ";
    } while (choice != 1 && choice != 2);

    cout << fixed << setprecision(2);
    
    // It is given that if choice != 1, choice == 2
    if (choice == 1) {
        int channels;
    
        cout << "Enter number of premium channels: ";
        do {
            cin >> channels;
            if (channels <= 0)
                cout << "Input cannot be negative or zero. Try again: ";
        } while (channels <= 0);
        
        processingFee = RES_PROC;
        serviceFee = RES_SRVC;
        channelFee = RES_CHNL * channels;
        
        cout << endl << "Processing fee: $" << processingFee << endl;
        cout << "Basic service fee: $" << serviceFee << endl;
        cout << "Premium channels: $" << RES_CHNL << " * " << channels << " channel(s) = $" << channelFee << endl;
    }
    else {
        int connections, channels;
    
        cout << "Enter number of connections: ";
        do {
            cin >> connections;
            if (connections <= 0)
                cout << "Input cannot be negative or zero. Try again: ";
        } while (connections <= 0);
        cout << "Enter number of premium channels: ";
        do {
            cin >> channels;
            if (channels <= 0)
                cout << "Input cannot be negative or zero. Try again: ";
        } while (channels <= 0);

        processingFee = BUS_PROC;
        channelFee = BUS_CHNL * channels;
        
        cout << endl << "Processing fee: $" << processingFee << endl;
        cout << "Basic service fee: $";
        if (connections <= 5) {
            serviceFee = BUS_SRVC_UNDER_5;
            cout << serviceFee << endl;
        }
        else {
            serviceFee = BUS_SRVC_UNDER_5 + (BUS_SRVC_OVER_5 * (connections - 5));
            cout << BUS_SRVC_UNDER_5 << " for 5 connections + ($";
            cout << BUS_SRVC_OVER_5 << " * " << connections - 5 << " add\'l connection(s)) = ";
            cout << serviceFee << endl;
        }
        cout << "Premium channels: $" << BUS_CHNL << " * " << channels << " channels = $" << channelFee << endl;
    }
    
    cableBill = processingFee + serviceFee + channelFee;
    cout << endl << "Cable bill amount: $" << processingFee << " + $" << serviceFee << " + $" << channelFee << " = $" << cableBill;
        
    return 0;
}

