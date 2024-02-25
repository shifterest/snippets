#include <iostream>
#include <iomanip>
#include <cctype>
using namespace std;

double proc, srvc, chnl, ttl;
const double RES_PROC = 4.5,
             RES_SRVC = 30,
             RES_CHNL = 5,
             BUS_PROC = 16.5,
             BUS_SRVC_UNDER_5 = 80,
             BUS_SRVC_OVER_5 = 4,
             BUS_CHNL = 50;

// For residential customers
double computePremiumChannelRes(int &numChannel) {
    do {
        cout << "Enter number of channels between [1-10]: ";
        cin >> numChannel;
    } while (numChannel < 1 || numChannel > 10);

    return numChannel * RES_CHNL;
}

double computeAmountRes(double processingFeeRes, double basicServiceFee, double premiumRes) {
    return processingFeeRes + basicServiceFee + premiumRes;
}

// For business customers
double computesServiceFeeBus(double numConnections) {
    if (numConnections <= 5) return BUS_SRVC_UNDER_5;
    else return BUS_SRVC_UNDER_5 + ((numConnections - 5) * BUS_SRVC_OVER_5);
}

double computePremiumChannelBus(double numChannels) {
    return numChannels * BUS_CHNL;
}

double computeAmountBus(double serviceFeeBus, double premiumChannelFee) {
    return proc + serviceFeeBus + premiumChannelFee;
}

void displayCharges(char type) {
    cout << fixed << setprecision(2);
    if (type == 'R') cout << "Residential Customer";
    else cout << "Business Customer";
    cout << endl << "========================================" << endl
         << "Processing fee:                $" << proc << endl
         << "Basic Service fee:             $" << srvc;
    if (type == 'B' && srvc > 80)
        cout << setprecision(0) << "    (" << BUS_SRVC_UNDER_5 << " + ("
             << (srvc - BUS_SRVC_UNDER_5) / BUS_SRVC_OVER_5
             << " * " << BUS_SRVC_OVER_5 << ")" << setprecision(2);
    cout << endl << "Premium Channel fee:           $" << chnl << "    (";
    cout << setprecision(0);
    if (type == 'R') cout << chnl / RES_CHNL << " * " << RES_CHNL;
    else cout << chnl / BUS_CHNL << " * " << BUS_CHNL;
    cout << ")" << setprecision(2)
         << endl << "                      ==================" << endl
         << "Total Amount to Pay:           $" << ttl;
}

int main () {
    char customerType;

    do {
        cout << "Enter R for Residential and B for Business type of customer: ";
        cin >> customerType;
        customerType = toupper(customerType);
    } while (customerType != 'R' && customerType != 'B');

    if (customerType == 'R') {
        int numChannels;
        proc = RES_PROC;
        srvc = RES_SRVC;
        chnl = computePremiumChannelRes(numChannels);
        ttl = computeAmountRes(proc, srvc, chnl);
    }
    else {
        double numConnections, numChannels;
        proc = BUS_PROC;
        do {
            cout << "Enter number of connections between [1-10]: ";
            cin >> numConnections;
        } while (numConnections < 1 || numConnections > 10);
        srvc = computesServiceFeeBus(numConnections);
        do {
            cout << "Enter number of premium channels between [1-10]: ";
            cin >> numChannels;
        } while (numChannels < 1 || numChannels > 10);
        chnl = computePremiumChannelBus(numChannels);
        ttl = computeAmountBus(srvc, chnl);
    }

    displayCharges(customerType);

    return 0;
}
