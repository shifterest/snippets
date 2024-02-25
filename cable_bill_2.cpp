#include <iostream>
#include <iomanip>
#include <cctype>
using namespace std;

int channels, connections;
double proc, srvc;
const double RES_PROC = 4.5,
             RES_SRVC = 30,
             RES_CHNL = 5,
             BUS_PROC = 16.5,
             BUS_SRVC_UNDER_5 = 80,
             BUS_SRVC_OVER_5 = 4,
             BUS_CHNL = 50;

void ResidentialCustomer (double &premiumChannels, double &amount);
void BusinessCustomer (double &basicServiceFee, double &premiumChannelsFee, double &amount);
void displayCharges (char type, double premiumChannelsFee, double amount);

int main () {
    char t;
    double chnl, amt;

    do {
        cout << "Enter R for Residential and B for Business type of customer: ";
        cin >> t;
        t = tolower(t);
    } while (t != 'r' && t != 'b');
        
    if (t == 'r') {
        proc = RES_PROC;
        srvc = RES_SRVC;
        ResidentialCustomer (chnl, amt);
    }
    else if (t == 'b') {
        proc = BUS_PROC;
        BusinessCustomer (srvc, chnl, amt);
    }

    displayCharges (t, chnl, amt);

    return 0;
}

void ResidentialCustomer (double &premiumChannels, double &amount) {
    do {
        cout << "Enter number of channels between [1-10]: ";
        cin >> channels;
    } while (channels < 1 || channels > 10);

    premiumChannels = RES_CHNL * channels;
    amount = proc + srvc + premiumChannels;
}

void BusinessCustomer (double &basicServiceFee, double &premiumChannelsFee, double &amount) {
    do {
        cout << "Enter number of connections between [1-10]: ";
        cin >> connections;
    } while (connections < 1 || connections > 10);
    do {
        cout << "Enter number of premium channels between [1-10]: ";
        cin >> channels;
    } while (channels < 1 || channels > 10);

    if (connections <= 5)
        basicServiceFee = BUS_SRVC_UNDER_5;
    else
        basicServiceFee = BUS_SRVC_UNDER_5 + (BUS_SRVC_OVER_5 * (connections - 5));
    premiumChannelsFee = BUS_CHNL * channels;
    amount = proc + basicServiceFee + premiumChannelsFee;
}

void displayCharges (char type, double premiumChannelsFee, double amount) {
    cout << fixed << setprecision(2);

    if (type == 'r') cout << "Residential Customer";
    else if (type == 'b') cout << "Business Customer";
    cout << endl << "========================================" << endl
         << "Processing fee:                $" << proc << endl
         << "Basic Service fee:             $" << srvc;
    if (type == 'b' && connections > 5) {
        cout << setprecision(0)
             << "    (" << BUS_SRVC_UNDER_5 << " + (" << connections - 5 << " * " << BUS_SRVC_OVER_5 << ")"
             << setprecision(2);
    }
    cout << endl << "Premium Channel fee:           $" << premiumChannelsFee
         << setprecision(0) << "    (" << channels << " * ";
    if (type == 'r') cout << RES_CHNL;
    else if (type == 'b') cout << BUS_CHNL;
    cout << ")" << setprecision(2) << endl
         << "                      ==================" << endl
         << "Total Amount to Pay:           $" << amount;
}
