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

        System.out.println("=== Membership Information ===\n");

        for (Membership membership : memberships) {
            System.out.println(membership);
            printCosts(membership);
            System.out.println();
        }

        BigDecimal monthlyIncome = BigDecimal.ZERO;
        BigDecimal allContracts = BigDecimal.ZERO;

        for (Membership membership : memberships) {
            monthlyIncome = monthlyIncome.add(
                    membership.calculateMonthlyFee());

            allContracts = allContracts.add(
                    membership.getContractTotal());
        }

        System.out.println("=== Totals ===");
        System.out.println("Memberships: "
                + memberships.size());

        System.out.println("Monthly Income: $"
                + monthlyIncome);

        System.out.println("All Contracts: $"
                + allContracts);

        System.out.println("\n=== Front Desk Processing ===");

        for (Membership membership : memberships) {

            if (membership instanceof BasicMembership) {

                BasicMembership basic =
                        (BasicMembership) membership;

                if (basic.isOffPeakOnly()) {
                    System.out.println(
                            basic.getMemberName()
                                    + ": entry between 10:00 and 16:00 only");
                }

            } else if (membership instanceof PremiumMembership) {

                PremiumMembership premium =
                        (PremiumMembership) membership;

                premium.useGuestPass();

            } else if (membership instanceof FamilyMembership) {

                FamilyMembership family =
                        (FamilyMembership) membership;

                System.out.println(
                        family.getMemberName()
                                + ": print "
                                + (family.getExtraMembers() + 1)
                                + " key cards");
            }
        }

        System.out.println("\n=== Membership Types ===");

        for (Membership membership : memberships) {
            System.out.println(
                    membership.getMemberName()
                            + ": "
                            + membership.getClass().getSimpleName());
        }
    }

    private static void printCosts(Membership membership) {

        System.out.println(
                "Monthly Fee: $"
                        + membership.calculateMonthlyFee());

        System.out.println(
                "Sign-Up Fee: $"
                        + membership.getSignUpFee());

        System.out.println(
                "Contract Total: $"
                        + membership.getContractTotal());
    }
}