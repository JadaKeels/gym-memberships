package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Membership> memberships = new ArrayList<>();
        BasicMembership alice = new BasicMembership(
                "Alice Johnson",
                6,
                new BigDecimal("30.00"),
                true);
        BasicMembership bob = new BasicMembership(
                "Bob Smith",
                12,
                new BigDecimal("30.00"),
                false);
        PremiumMembership carol = new PremiumMembership(
                "Carol White",
                12,
                new BigDecimal("30.00"),
                3);
        PremiumMembership frank = new PremiumMembership(
                "Frank Miller",
                6,
                new BigDecimal("30.00"),
                1);
        FamilyMembership grace = new FamilyMembership(
                "Grace Lee",
                12,
                new BigDecimal("30.00"),
                3);
        FamilyMembership emma = new FamilyMembership(
                "Emma Wilson",
                6,
                new BigDecimal("30.00"),
                2);
        memberships.add(alice);
        memberships.add(bob);
        memberships.add(carol);
        memberships.add(frank);
        memberships.add(grace);
        memberships.add(emma);
        for (Membership membership : memberships) {
            System.out.println(membership);
            printCosts(membership);
            System.out.println();
        }
    }

    private static void printCosts(Membership membership) {
        System.out.println("Monthly Price: $"
                + membership.getMonthlyPrice());
        System.out.println("Sign-Up Fee: $"
                + membership.getSignUpFee());
        System.out.println("Contract Total: $"
                + membership.getContractTotal());
    }
}
